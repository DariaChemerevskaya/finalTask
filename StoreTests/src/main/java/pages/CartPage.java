package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBys({
            @FindBy(className = "cart_item"),
            @FindBy(className = "cart_description")
    })
    List<WebElement> cartItems;

    @FindBys({
            @FindBy(className = "icon-trash")
    })
    List<WebElement> trashIcons;

    @FindBy(className = "alert-warning")
    WebElement warningMessage;

    @FindBy(className = "standard-checkout")
    WebElement proceedToCheckoutInSummaryButton;

    @FindBy(name = "processAddress")
    WebElement proceedToCheckoutInAddressButton;

    @FindBy(name = "processCarrier")
    WebElement proceedToCheckoutInShippingButton;

    @FindBy(id = "uniform-cgv")
    WebElement termsOfService;

    @FindBy(className = "bankwire")
    WebElement bankWirePayment;

    @FindBy(xpath = "//button/span[text() = 'I confirm my order']")
    WebElement confirmOrderButton;

    public String getCartItemDescription(int index) {
        return cartItems.get(index).getText();
    }

    public void deleteProductFromCart(int index) {
        trashIcons.get(index).click();
    }

    public String getWarningMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(warningMessage));
        return warningMessage.getText();
    }

    public void proceedToCheckoutInSummary(){
        proceedToCheckoutInSummaryButton.click();
    }

    public void proceedToCheckoutInAddress(){
        proceedToCheckoutInAddressButton.click();
    }

    public void proceedToCheckoutInShipping(){
        proceedToCheckoutInShippingButton.click();
    }

    public void agreeToTermsOfService() {
        if (!termsOfService.isSelected()) {
            termsOfService.click();
        }
    }

    public void payByBankWire() {
        bankWirePayment.click();
    }

    public void confirmOrder() {
       confirmOrderButton.click();
    }

    public void checkoutWithDefaultSettingsAndBankWire(){
        this.proceedToCheckoutInSummary();
        this.proceedToCheckoutInAddress();
        this.agreeToTermsOfService();
        this.proceedToCheckoutInShipping();
        this.payByBankWire();
        this.confirmOrder();
    }

}
