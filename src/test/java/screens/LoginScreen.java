package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginScreen {
    SelenideElement hiUserText = $x("//android.widget.TextView[@text=\"Привет, Tsoy Ann Viktorovna\"]"),
            login = $x("//android.view.View[@resource-id=\"__nuxt\"]/android.view.View[1]/android.widget.ListView[1]/android.view.View"),
            phoneInput = $x("//android.widget.EditText[@text=\"+998\"]"),
            passwordInput = $x("//android.view.View[@resource-id=\"__nuxt\"]/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.EditText"),
            buttonEnter = $x("//android.widget.Button[@text=\"Войти\"]"),
            buttonProfile = $x("//android.view.View[@content-desc=\"logo Профиль\"]");

    public void authorizationUser() {
        // List<String> credentials = step("Получить пароль из файла",()-> readSecretFiles("credentialsasialuxe"));
        step("Нажать в поле меню на Профиль", () -> buttonProfile.click());
        step("Нажать на Логин", () -> login.click());
        step("Установить курсор на поле Номер", () -> phoneInput.click());
        step("Установить номер в поле Номер", () -> phoneInput.sendKeys("909190023"));
        step("Установить курсор на поле Пароль", () -> passwordInput.click());
        //step("Установить пароль в поле Пароль",()->passwordInput.sendKeys(credentials.get(1)));
        step("Установить пароль в поле Пароль", () -> passwordInput.sendKeys("123123123"));
        step("Нажать на кнопку Войти", () -> buttonEnter.click());
        assertEquals("Привет, Tsoy Ann Viktorovna", hiUserText.getText());
    }
}
