import driverSingleton.WebDriverSingleton;
import model.Address;
import model.ContactUsMessage;
import model.PersonalInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StoreTests {
    WebDriver driver;
    File f1;
    File f2;

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod() {
        driver = WebDriverSingleton.create();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @BeforeClass(alwaysRun = true)
    public void createFiles() {
        f1 = new File("D:\\test1.txt");
        f2 = new File("D:\\test2.txt");
        try {
            f1.createNewFile();
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void finish() {
        WebDriverSingleton.kill();
    }

    @AfterClass(alwaysRun = true)
    public void deleteFiles() {
        f1.delete();
        f2.delete();
    }

    @Test
    public void sendContactUsForm() {
        ContactUsPage contactUsPage = new ContactUsPage();
        MainPage mainPage = new MainPage();
        ContactUsMessage message = new ContactUsMessage("Webmaster", "test@test.com", "Order", "D:\\test1.txt", "Message");

        mainPage.openContactUs();
        contactUsPage.sendContactUsMessage(message);

        Assert.assertEquals(contactUsPage.getSuccessfulMessageText(), "Your message has been successfully sent to our team.", "Message should be 'Your message has been successfully sent to our team.'");
    }

    @Test
    public void sendContactUsFormWithEmptyMessage() {
        ContactUsPage contactUsPage = new ContactUsPage();
        MainPage mainPage = new MainPage();
        ContactUsMessage message = new ContactUsMessage("Webmaster", "test@test.com", "Order", "D:\\test2.txt", "");

        mainPage.openContactUs();
        contactUsPage.sendContactUsMessage(message);

        Assert.assertEquals(contactUsPage.getErrorMessageText(), "There is 1 error\n" +
                "The message cannot be blank.", "Message should be 'There is 1 error\n" +
                "The message cannot be blank.'");
    }

    @Test
    public void search() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();

        mainPage.search("Blouse");

        Assert.assertTrue(searchPage.isEachProductContains("Blouse"), "All product names should contain 'Blouse'");
    }

    @Test
    public void catalogNavigation() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();

        mainPage.hoverTopMenuItem("Women");
        mainPage.clickTopSubmenuLink("T-shirts");

        Assert.assertTrue(searchPage.isEachProductContains("T-shirt"), "All product names should contain 'T-shirt'");

    }

    @Test
    public void registration() {
        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.ddHHmmss");
        String testEmail = dateFormat.format(new Date()) + "@mailinator.com";
        PersonalInfo personalInfo = new PersonalInfo("Mrs", "Darya", "Chemerevskaya", testEmail, "qwer1234", "5/5/1994");
        Address addressInfo = new Address("test company", "55088 Darwin Place", "Sioux City", "Iowa", "51110", "123456789", "712-335-2490", "55088 Darwin Place");

        mainPage.openSignIn();
        registrationPage.enterEmailAddress(personalInfo.getEmail());
        registrationPage.clickCreateAnAccountButton();
        registrationPage.enterPersonalInformation(personalInfo);
        registrationPage.setNewsletterCheckbox();
        registrationPage.enterAddressDetails(addressInfo);
        registrationPage.clickRegisterButton();

        Assert.assertEquals(myAccountPage.getCustomerAccountDetails(), personalInfo.getFirstName() + " " + personalInfo.getLastName(), "Header user info should be '" + personalInfo.getFirstName() + " " + personalInfo.getLastName() + "'");
        Assert.assertEquals(myAccountPage.getHeadingText(), "MY ACCOUNT", "Page heading should be 'MY ACCOUNT'");
    }


    @Test
    public void addProductToCart() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        CartPage cartPage = new CartPage();

        mainPage.search("Blouse");
        searchPage.addProductToCart(0);
        searchPage.proceedToCheckout();

        Assert.assertTrue(cartPage.getCartItemDescription(0).contains("Blouse"));
    }

    @Test
    public void deleteProductFromCart() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        CartPage cartPage = new CartPage();

        mainPage.search("Blouse");
        searchPage.addProductToCart(0);
        searchPage.proceedToCheckout();
        cartPage.deleteProductFromCart(0);

        Assert.assertEquals(cartPage.getWarningMessageText(), "Your shopping cart is empty.", "Message should be 'Your shopping cart is empty.'");
    }

    @Test
    public void buyProduct(){
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        RegistrationPage registrationPage = new RegistrationPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        CartPage cartPage = new CartPage();
        OrderHistory orderHistory = new OrderHistory();
        PersonalInfo personalInfo = new PersonalInfo("Mr", "Rex", "Wallbrook", "testUserBuyProduct@mailinator.com", "qwer1234", "5/5/1994");
        mainPage.openSignIn();
        registrationPage.login(personalInfo.getEmail(), personalInfo.getPassword());
        mainPage.search("Dress");
        searchPage.addProductToCart(0);
        searchPage.proceedToCheckout();
        cartPage.checkoutWithDefaultSettingsAndBankWire();
        mainPage.openCustomerAccount();
        myAccountPage.openOrderHistory();
        orderHistory.openOrderDetails();

        Assert.assertTrue(orderHistory.getProductName().contains("Dress"), "Product name should contain 'Dress'");

    }

    @Test
    public void searchWithoutKeyword() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        mainPage.searchWithoutKeyword();

        Assert.assertEquals(searchPage.getWarningMessageText(), "Please enter a search keyword", "Message should be 'Please enter a search keyword'");

    }

    @Test
    public void login() {
        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        PersonalInfo personalInfo = new PersonalInfo("Mrs", "Elita", "Eyckelbeck", "testUserLogin@mailinator.com", "qwer1234", "5/5/1994");

        mainPage.openSignIn();
        registrationPage.login(personalInfo.getEmail(), personalInfo.getPassword());

        Assert.assertEquals(myAccountPage.getCustomerAccountDetails(), personalInfo.getFirstName() + " " + personalInfo.getLastName(), "Header user info should be 'Darya Chemerevskaya'");
    }

    @Test
    public void invalidEmailFormatForLogin() {
        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();

        mainPage.openSignIn();
        registrationPage.login("invalidEmailFormat", "password");

        Assert.assertEquals(registrationPage.getExistingEmailColor(), "rgba(156, 155, 155, 1)", "Color should be 'rgba(156, 155, 155, 1)'");
    }

    @Test
    public void checkPopularTabActive() {
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.getColorForPopularTab(), "rgba(255, 255, 255, 1)", "Color should be 'rgba(255, 255, 255, 1)'");
    }

    @Test
    public void checkBestsellersTabDisplayed() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isBestSellersTabDisplayed(), "Bestsellers tab should be displayed");
    }

}
