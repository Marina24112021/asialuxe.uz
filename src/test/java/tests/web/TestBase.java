package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ReaderConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    private static final String devicehost = System.getProperty("devicehost", "emulation");

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://asialuxe.uz";
        new ReaderConfig();
    }

    @BeforeEach
    public void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        if (devicehost.equals("browserstack")) {
            Attach.addVideo();
        }
        if (devicehost.equals("emulation")) {
            Attach.screenshotAs("Last screenshot");
        }
        Attach.pageSource();
        closeWebDriver();
    }
}
