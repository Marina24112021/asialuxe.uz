package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.mobile.TestBaseMobile;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AboutCompanyScreenTest {
    SelenideElement buttonProfile = $x("//android.view.View[@content-desc=\"logo Профиль\"]");
    SelenideElement buttonAboutCompany = $x("//android.widget.TextView[@text=\"О компании\"]");
    SelenideElement titleAboutCompany = $x("//android.widget.TextView[@text=\"Asialuxe Travel\"]");
    SelenideElement titleServices = $x("//android.widget.TextView[@text=\"Услуги выездного туризма\"]");

    public void checkListOfTitles() {
        step("Нажать в поле меню на Профиль", () -> buttonProfile.click());
        step("Нажать на О Компании", () -> buttonAboutCompany.click());
        String titleAsiatravel = step("Получить значение заголовка статьи", () -> titleAboutCompany.getText());
        String titleServ = step("Получить значение заголовка статьи", () -> titleServices.getText());
        assertEquals("Asialuxe Travel", titleAsiatravel);
        assertEquals("Услуги выездного туризма", titleServ);
    }
}
