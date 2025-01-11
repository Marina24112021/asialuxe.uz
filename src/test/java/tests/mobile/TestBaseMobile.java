package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulationDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseMobile {
    private static final String devicehost = System.getProperty("devicehost", "browserstack");

    @BeforeAll
    static void beforeAll() {
        if (devicehost.equals("emulation")) {
            Configuration.browser = EmulationDriver.class.getName();
        } else if (devicehost.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        if (devicehost.equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            Attach.addVideo(sessionId);
        }
        if (devicehost.equals("emulation")) {
            Attach.screenshotAs("Last screenshot");
        }
        Attach.pageSource();
        closeWebDriver();
    }
}
