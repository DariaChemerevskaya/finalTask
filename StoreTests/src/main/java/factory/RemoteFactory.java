package factory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFactory extends WebDriverFactory{
    @Override
    public WebDriver create() {
        String remoteHost = System.getProperty("remoteHost");
        String remotePort = System.getProperty("remotePort");
        if (remoteHost == null) {
            remoteHost = "localhost";
        }
        if (remotePort == null) {
            remotePort = "4444";
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("platform", Platform.WINDOWS);
        try {
            return new RemoteWebDriver(new URL("http://" + remoteHost + ":" + remotePort + "/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            return null;
        }
    }

}
