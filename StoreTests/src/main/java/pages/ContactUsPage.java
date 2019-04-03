package pages;

import model.ContactUsMessage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage{
    public ContactUsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "id_order")
    WebElement orderInput;

    @FindBy(id = "fileUpload")
    WebElement uploadFileInput;

    @FindBy(id = "message")
    WebElement messageInput;

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(className = "alert-success")
    WebElement successMessage;

    @FindBy(className = "alert-danger")
    WebElement errorMessage;

    public void selectSubjectHeading(String optionName) {
        Select subjectHeadingSelect = new Select(subjectHeading);
        subjectHeadingSelect.selectByVisibleText(optionName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterOrderRef(String orderRef) {
        orderInput.sendKeys(orderRef);
    }

    public void uploadFile(String path) {
        uploadFileInput.sendKeys(path);
    }

    public void enterMessage(String message) {
        messageInput.sendKeys(message);
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public String getSuccessfulMessageText() {
        return successMessage.getText();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void sendContactUsMessage(ContactUsMessage message) {
        this.selectSubjectHeading(message.getSubjectHeading());
        this.enterEmail(message.getEmail());
        this.enterOrderRef(message.getOrderRef());
        this.uploadFile(message.getFilePath());
        this.enterMessage(message.getMessage());
        this.clickSendButton();
    }
}
