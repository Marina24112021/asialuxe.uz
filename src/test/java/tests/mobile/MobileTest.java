package tests.mobile;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.AboutCompanyScreenTest;
import screens.MainScreen;
import screens.PromotionArchive;
import screens.WhereToBuyScreen;

@Tag("emulation")
@Tag("browserstack")

public class MobileTest extends TestBaseMobile {
    @Test
    @Description("Проверка статичных заголовок на основной странице")
    void checkTitleOnMainPage() {
        MainScreen main = new MainScreen();
        main.checkStaticTitles();
    }

    @Test
    @Description("Проверка статичного заголовка на странице О Компании")
    void checkListOfTitleInProfileTest() {
        AboutCompanyScreenTest about = new AboutCompanyScreenTest();
        about.checkListOfTitles();
    }

    @Test
    @Description("Проверка адреса филиала на странице Офисы продаж")
    void checkTitleOfPromotionArchiveTest() {
        PromotionArchive prom = new PromotionArchive();
        prom.checkTitleOfArticle();
    }

    @Test
    @Description("Проверка адреса филиала на странице Офисы продаж")
    void checkAddressesOfSalesAgenciesTest() {
        WhereToBuyScreen user = new WhereToBuyScreen();
        user.checkAddressesOfSalesAgenciesTest();
    }
}
