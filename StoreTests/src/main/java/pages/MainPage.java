package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "homefeatured")
    WebElement popularTab;

    @FindBy(className = "blockbestsellers")
    WebElement bestSellersTab;

    public String getColorForPopularTab() {
        return popularTab.getCssValue("color");
    }

    public boolean isBestSellersTabDisplayed() {
        return bestSellersTab.isDisplayed();
    }

}
