package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static helpers.ReadFileToList.readSecretFiles;
import static specs.Endpoints.SECRET_FILE_PATH_FOR_SELENOID;

public class ConfigReader {
    private final WebDriverConfig config;

    public ConfigReader() throws IOException {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        readConfiguration();
    }

    public void readConfiguration() throws IOException {
        Configuration.browser = config.getBrowserName().toString();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();

        if (config.isRemote().equals(true)) {
            Properties credentials = readSecretFiles(SECRET_FILE_PATH_FOR_SELENOID);
            Configuration.remote = "https://" + credentials.getProperty("login") + ":" + credentials.getProperty("password") + config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
