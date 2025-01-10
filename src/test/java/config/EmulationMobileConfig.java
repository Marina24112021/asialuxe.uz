package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/emulation.properties"})

public interface EmulationMobileConfig extends Config {
    @Key("appiumServerUrl")
    String getAppiumServerUrl();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}
