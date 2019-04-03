package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistory extends BasePage {

    public OrderHistory() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href, 'controller=order-detail')]")
    WebElement orderDetailsLink;

    @FindBy(xpath = "//td[@class='bold']")
    WebElement productName;


    public void openOrderDetails() {
        orderDetailsLink.click();
    }

    public String getProductName() {
        return productName.getText();
    }

}
