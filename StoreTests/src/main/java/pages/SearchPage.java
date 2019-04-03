package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "alert-warning")
    WebElement warningMessage;

    @FindBys({
            @FindBy(css = ".product_list .product-name")
    })
    List<WebElement> productNames;

    @FindBys({
            @FindBy(css = ".product_list .ajax_add_to_cart_button span")
    })
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    public boolean isEachProductContains(String searchCriteria) {
        boolean result = true;
        for (WebElement productName : productNames) {
            if (!productName.getText().contains(searchCriteria)) {
                result = false;
                break;
            }

        }
        return result;
    }

    public void addProductToCart(int index) {
        Actions builder = new Actions(driver);
        WebElement item = productNames.get(index);
        builder.moveToElement(item).build().perform();
        addToCartButtons.get(index).click();
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }

}
