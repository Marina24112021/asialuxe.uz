package tests.web;

import helpers.extensions.WithLogin;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;


@Owner("Marina Chen")
@Tag("smoke")
public class AsialuxeMainTest extends TestBase {
    @Test
    @WithLogin
    @DisplayName("Проверка отображения сообщения при поиске билетов")
    void checkMessageOfSearchingIsAppearedInSearchPanelOnMainPageTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkSearchPanel();
    }

    @WithLogin
    @Test
    @DisplayName("Проверка корректного текста в меню")
    void checkTitlesOfHeaderMenuIsCorrectDisplayedOnMainPageTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkNamesOfMenu();
    }

    @Test
    @WithLogin
    @DisplayName("Проверка отображения наполнения текста для блока Почему мы")
    void checkContentOfWhyUsBlockIsOnMainPageTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkBlockAboutAgencyCompareThroughFile();
    }
}