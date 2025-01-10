package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.WebDriverMobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    public static final WebDriverMobileConfig config = ConfigFactory.create(WebDriverMobileConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", config.getUserName());
        caps.setCapability("browserstack.key", config.getAccessKey());

        // Set URL of the application under test
        caps.setCapability("apps", config.getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", config.getDevice());
        caps.setCapability("os_version", config.getOs_version());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(config.getRemoteURL()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
