package helpers.extensions;

import api.account.Authorization;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Authorization.userAuthorization();
        step("Открыть тестовую страницу", () -> open("/images/mini_logo_white.svg"));
        getWebDriver().manage().addCookie(new Cookie("token",
                "accessJ8nf6g7-dEZz2NoH3RQ37wgJpkqLwZ95EplijyuY7ecC4h4-1Kiq3QFAZCXWT06a1736017304whW7ghmfsC-Mq3b4JukSh_3piVAeVttpmobile"));
    }
}
