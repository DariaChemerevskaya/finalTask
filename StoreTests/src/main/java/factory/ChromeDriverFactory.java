package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory extends WebDriverFactory {
    @Override
    public WebDriver create() {
        return new ChromeDriver();
    }
}