package config;


import org.aeonbits.owner.Config;
import org.checkerframework.checker.units.qual.K;

@Config.Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/browserstack.properties"})

public interface BrowserstackConfig extends Config {
    @Key("browserstack.userName")
    String getUserName();

    @Key("browserstack.accessKey")
    String getAccessKey();

    @Key("app")
    String getApp();

    @Key("remoteUrl")
    String getRemoteURL();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOs_version();

    @Key("platformName")
    String getPlatformName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}