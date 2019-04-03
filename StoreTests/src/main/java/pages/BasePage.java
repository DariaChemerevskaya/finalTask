package pages;

import driverSingleton.WebDriverSingleton;
import elements.Header;
import org.openqa.selenium.WebDriver;


public class BasePage {
    protected WebDriver driver = WebDriverSingleton.create();

    private Header header;

    public BasePage() {
        header = new Header();
    }

    public void openContactUs() {
        header.clickContactUs();
    }

    public void openSignIn() {
        header.clickSignIn();
    }

    public void openCustomerAccount() {
        header.clickCustomerAccount();
    }

    public void search(String searchPhrase) {
        header.search(searchPhrase);
    }

    public String getCustomerAccountDetails() {
        return header.getUsernameText();
    }

    public void searchWithoutKeyword() {
        header.clickSubmitSearch();
    }

    public void hoverTopMenuItem(String itemName) {
        header.hoverTopMenuItem(itemName);
    }

    public void clickTopSubmenuLink(String linkText) {
        header.clickTopSubmenuLink(linkText);
    }
}
