package helpers.extensions;

import api.authorization.Authorization;
import api.models.authorization.AuthorizationResponseModel;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws IOException {
        AuthorizationResponseModel responseModel = Authorization.userAuthorization();
        step("Открыть тестовую страницу", () -> open("/images/mini_logo_white.svg"));
        getWebDriver().manage().addCookie(new Cookie("token", responseModel.getData().getToken()));
    }
}
