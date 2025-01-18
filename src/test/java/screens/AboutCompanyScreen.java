package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AboutCompanyScreen {
    final SelenideElement buttonProfile = $x("//android.view.View[@content-desc=\"logo Профиль\"]");
    final SelenideElement buttonAboutCompany = $x("//android.widget.TextView[@text=\"О компании\"]");
    final SelenideElement titleAboutCompany = $x("//android.widget.TextView[@text=\"Asialuxe Travel\"]");
    final SelenideElement titleServices = $x("//android.widget.TextView[@text=\"Услуги выездного туризма\"]");

    public AboutCompanyScreen clickOnProfile() {
        step("Нажать в поле меню на Профиль", () -> buttonProfile.click());
        return this;
    }

    public AboutCompanyScreen clickOnAboutCompany() {
        step("Нажать на О Компании", () -> buttonAboutCompany.click());
        return this;
    }

    public AboutCompanyScreen checkTitleOfAboutCompany() {
        step("Получить значение заголовка статьи", () ->
                assertEquals("Asialuxe Travel", titleAboutCompany.getText()));
        return this;
    }

    public void checkTitleOfServices() {
        step("Получить значение заголовка статьи", () ->
                assertEquals("Услуги выездного туризма", titleServices.getText()));
    }
}
