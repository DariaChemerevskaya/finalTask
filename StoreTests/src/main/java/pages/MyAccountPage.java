package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{

    public MyAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-heading")
    WebElement heading;

    @FindBy(xpath = "//a[@title = 'Orders']")
    WebElement orderHistoryButton;

    public String getHeadingText() {
        return heading.getText();
    }

    public void openOrderHistory() {
        orderHistoryButton.click();
    }

}
