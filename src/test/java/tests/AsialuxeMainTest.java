package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.helpers.extensions.WithLogin;
import tests.pages.MainPage;

@Owner("Marina Chen")
public class AsialuxeMainTest extends TestBase {
    @Test
    @WithLogin
    @DisplayName("Проверка отображения сообщения при поиске билетов")
    @Tag("smoke")
    void checkMessageOfSearchingIsAppearedInSearchPanelOnMainPageTest(){
        MainPage mainPage = new MainPage();
        mainPage.checkSearchPanel();
    }
    @WithLogin
    @Test
    @DisplayName("Проверка корректного текста в меню")
    @Tag("smoke")
    void checkTitlesOfHeaderMenuIsCorrectDisplayedOnMainPageTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkNamesOfMenu();
    }
    @Test
    @WithLogin
    @DisplayName("Проверка отображения наполнения текста для блока Почему мы")
    @Tag("smoke")
    void checkContentOfWhyUsBlockIsOnMainPageTest() throws Exception {
        MainPage mainPage = new MainPage();
        mainPage.checkBlockAboutAgencyCompareThroughFile();
    }
}
