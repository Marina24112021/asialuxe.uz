package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    public static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
       MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("app", config.getApp());
        caps.setCapability("platformName", config.getPlatformName());
        caps.setCapability("deviceName", config.getDevice());
        caps.setCapability("os_version", config.getOs_version());

        caps.setCapability("appPackage", config.getAppPackage());
        caps.setCapability("appActivity", config.getAppActivity());

        caps.setCapability("project", "BrowserStack Java/Android/Appium Project");
        caps.setCapability("build", "browserstackbuild");
        caps.setCapability("name", "asialuxeTest");

        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.networkLogs", "true");

        String browserStackUrl = "https://"+config.getUserName()+":"+config.getAccessKey()+"@hub-cloud.browserstack.com/wd/hub";
        try {
            return new RemoteWebDriver(new URL(browserStackUrl), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
