package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Map;

import static helpers.ReadFileToList.readSecretFiles;

public class ReaderConfig {
    private final WebDriverConfig config;

    public ReaderConfig() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        createWebDriver();
    }

    public void createWebDriver() {
        Configuration.browser = config.getBrowserName().toString();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();

        if (config.isRemote().equals(true)) {
            List<String> credentials = readSecretFiles("selenoidcredentionals");
            Configuration.remote = "https://"+credentials.get(0)+credentials.get(1)+":"+config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
