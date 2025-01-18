package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhereToBuyScreen {
    final SelenideElement buttonProfile = $x("//android.view.View[@content-desc=\"logo Профиль\"]");
    final SelenideElement buttonWhereToBuy = $x("//android.widget.TextView[@text=\"Где купить?\"]");
    final SelenideElement addressAbout = $x("//android.widget.TextView[@text=\"Адрес:Ташкент, Ц15, Жангох 9\"]");
    final SelenideElement titleArticle = $x("//android.widget.TextView[@text=\"Узбекистан\"]");

    public WhereToBuyScreen clickOnProfile() {
        step("Нажать в поле меню на Профиль",
                () -> buttonProfile.click());
        return this;
    }

    public WhereToBuyScreen clickOnWhereToBuy() {
        step("Нажать на Где купить?", () -> buttonWhereToBuy.click());
        return this;
    }

    public WhereToBuyScreen checkTitleOfAbout() {
        assertEquals("Адрес:Ташкент, Ц15, Жангох 9",
                step("Получить данные адреса", addressAbout::getText));
        return this;
    }

    public void checkTitleOfExpArticle() {
        assertEquals("Узбекистан",
                step("Получить название страны", titleArticle::getText));
    }
}
