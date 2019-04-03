package pages;

import model.Address;
import model.PersonalInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    public RegistrationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    WebElement emailAddressInput;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    @FindBy(id = "email")
    WebElement existingEmailInput;

    @FindBy(id = "passwd")
    WebElement existingPasswordInput;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(id = "customer_firstname")
    WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    WebElement lastNameInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "days")
    WebElement daySelect;

    @FindBy(id = "months")
    WebElement monthSelect;

    @FindBy(id = "years")
    WebElement yearSelect;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement address1Input;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "id_state")
    WebElement stateSelect;

    @FindBy(id = "postcode")
    WebElement postcodeInput;

    @FindBy(id = "other")
    WebElement additionalInfoInput;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    WebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    public void enterEmailAddress(String email) {
        emailAddressInput.sendKeys(email);
    }

    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void setDay(String dayValue) {
        Select day = new Select(daySelect);
        day.selectByValue(dayValue);
    }

    public void setMonth(String monthValue) {
        Select day = new Select(monthSelect);
        day.selectByValue(monthValue);
    }

    public void setYear(String yearValue) {
        Select day = new Select(yearSelect);
        day.selectByValue(yearValue);
    }

    public void setNewsletterCheckbox() {
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    public void enterCompany(String company) {
        companyInput.sendKeys(company);
    }

    public void enterAddress1(String address1) {
        address1Input.sendKeys(address1);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void setState(String stateValue) {
        Select state = new Select(stateSelect);
        state.selectByVisibleText(stateValue);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void enterPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
    }

    public void enterAdditionalInfo(String additionalInfo) {
        additionalInfoInput.sendKeys(additionalInfo);
    }

    public void enterMobilePhone(String mobilePhone) {
        mobilePhoneInput.sendKeys(mobilePhone);
    }

    public void enterAddressAlias(String addressAlias) {
        addressAliasInput.sendKeys(addressAlias);
    }

    public void setTitle(String title) {
        driver.findElement(By.xpath("//label[text()[contains(., '" + title + "')]]")).click();
    }

    public void enterPersonalInformation(PersonalInfo information) {
        this.setTitle(information.getTitle());
        this.enterFirstName(information.getFirstName());
        this.enterLastName(information.getLastName());
        this.enterPassword(information.getPassword());
        String [] date = information.getDateOfBirth().split("/");
        this.setDay(date[0]);
        this.setMonth(date[1]);
        this.setYear(date[2]);
    }

    public void enterAddressDetails(Address address) {
        this.enterCompany(address.getCompany());
        this.enterAddress1(address.getAddress());
        this.enterCity(address.getCity());
        this.setState(address.getState());
        this.enterPostcode(address.getPostalCode());
        this.enterAdditionalInfo(address.getInformation());
        this.enterMobilePhone(address.getMobilePhone());
        this.enterAddressAlias(address.getAddressAlias());
    }

    public void enterExistingEmail(String email) {
        existingEmailInput.sendKeys(email);
    }

    public void enterExistingPassword(String password) {
        existingPasswordInput.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void login(String email, String password) {
        this.enterExistingEmail(email);
        this.enterExistingPassword(password);
        this.clickSignInButton();
    }

    public String getExistingEmailColor() {
        return existingEmailInput.getCssValue("color");
    }
}
