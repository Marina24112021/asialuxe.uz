package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/local.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browser.name")
    @DefaultValue("chrome")
    BrowserNames getBrowserName();

    @Key("browser.version")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();
}
