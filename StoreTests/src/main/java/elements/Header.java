package elements;

import driverSingleton.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    private WebDriver driver = WebDriverSingleton.create();

    public Header() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_query_top")
    WebElement searchInput;

    @FindBy(id = "contact-link")
    WebElement contactUsLink;

    @FindBy(className = "login")
    WebElement signInLink;

    @FindBy(xpath = "//*[@class='header_user_info']//a[contains(@href, 'my-account')]")
    WebElement username;

    @FindBy(name = "submit_search")
    WebElement submitSearchButton;

    @FindBy(id = "block_top_menu")
    WebElement blockTopMenu;

    @FindBy(xpath = "//ul[contains(@class, 'submenu-container')]")
    WebElement topSubmenu;

    public void search(String searchPhrase) {
        searchInput.sendKeys(searchPhrase + Keys.ENTER);
    }

    public void clickContactUs() {
        contactUsLink.click();
    }

    public void clickSignIn() {
        signInLink.click();
    }

    public String getUsernameText() {
        return username.getText();
    }

    public void clickSubmitSearch() {
        submitSearchButton.click();
    }

    public void hoverTopMenuItem(String itemName) {
        Actions builder = new Actions(driver);
        WebElement item = blockTopMenu.findElement(By.xpath(".//a[@title='" + itemName + "']"));
        builder.moveToElement(item).build().perform();
    }

    public void clickTopSubmenuLink(String linkText) {
        topSubmenu.findElement(By.xpath(".//a[@title='" + linkText + "']")).click();
    }

    public void clickCustomerAccount() {
        username.click();
    }

}
