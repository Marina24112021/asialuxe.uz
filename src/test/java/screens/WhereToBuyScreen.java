package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhereToBuyScreen {
    SelenideElement buttonProfile = $x("//android.view.View[@content-desc=\"logo Профиль\"]");
    SelenideElement buttonWhereToBuy = $x("//android.widget.TextView[@text=\"Где купить?\"]");
    SelenideElement addressAbout = $x("//android.widget.TextView[@text=\"Адрес:Ташкент, Ц15, Жангох 9\"]");
    SelenideElement titleArticle = $x("//android.widget.TextView[@text=\"Узбекистан\"]");

    public void checkAddressesOfSalesAgenciesTest(){
        step("Нажать в поле меню на Профиль", () -> buttonProfile.click());
        step("Нажать на Где купить?", () -> buttonWhereToBuy.click());
        String titleAbout = step("Получить данные адреса", () -> addressAbout.getText());
        String titleExpArticle= step("Получить название страны", () -> titleArticle.getText());
        assertEquals("Адрес:Ташкент, Ц15, Жангох 9", titleAbout);
        assertEquals("Узбекистан", titleExpArticle);
    }

}
