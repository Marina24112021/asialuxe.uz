package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionArchive {
    final SelenideElement buttonProfile = $x("//android.view.View[@content-desc=\"logo Профиль\"]");
    final SelenideElement buttonArchive = $x("//android.view.View[@resource-id=\"__nuxt\"]/android.view.View[1]/android.widget.ListView[2]/android.view.View[4]");
    final SelenideElement titleArchive = $x("//android.webkit.WebView[@text=\"Архив акций\"]");
    final SelenideElement titleMore = $x("//android.widget.TextView[@text=\"Узнать подробнее\"]");

    public PromotionArchive clickOnProfile() {
        step("Нажать в поле меню на Профиль",
                () -> buttonProfile.click());
        return this;
    }

    public PromotionArchive clickOnArchive() {
        step("Нажать на Архив акций",
                () -> buttonArchive.click());
        return this;
    }

    public PromotionArchive checkTitleOfArchive() {
        assertEquals("Архив акций",
                step("Получить значение заголовка статьи", titleArchive::getText));
        return this;
    }

    public void checkTitleOfServices() {
        assertEquals("Узнать подробнее",
                step("Получить значение заголовка статьи", titleMore::getText));
    }
}
