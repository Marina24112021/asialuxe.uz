package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulationMobileConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class EmulationDriver implements WebDriverProvider {
    public static final EmulationMobileConfig config = ConfigFactory.create(EmulationMobileConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.getAppiumServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.getPlatformVersion())
                .setDeviceName(config.getDeviceName())
                .setApp(getAppPath())
                .setAppPackage(config.getAppPackage())
                .setAppActivity(config.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appPath = "src/test/resources/apps/uz_asialuxe_twa_nga_v2.1.0.0.apk";
        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}
