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
    MainPage mainPage = new MainPage();

    @Test
    @WithLogin
    @DisplayName("Отображение сообщения при поиске билетов")
    void checkMessageOfSearchingIsAppearedInSearchPanelOnMainPageTest() {
        mainPage.openMainPage()
                .clickOnFieldWhere()
                .fillInputWhereFrom()
                .selectFirstValueWhereFrom()
                .fillInputWhereTo()
                .selectFirstValueWhereTo()
                .removeAttr()
                .fillInputDate()
                .clickOnSearch()
                .checkMessageOfSearching();
    }

    @Test
    @DisplayName("Проверка текста в меню находящемся в хэдере сайта")
    public void checkTitlesOfHeaderMenuIsCorrectDisplayedOnMainPageTest() {
        mainPage.openMainPage()
                .checkTextInMenu("Авиа", "Отели", "Туры", "Чартеры", "Трансферы");
    }

    @Test
    @DisplayName("Сообщение о некорректном вводе данных авторизации")
    public void checkAlertIsAppearedIfCredentialsIsUncorrectedTest(){
        mainPage.openMainPage()
                .clickOnLoginToOpenLoginForm()
                .setLogin()
                .setPassword()
                .clickOnLogin();
        mainPage.runScriptToFrozenAlertMessage();
        mainPage.checkAlertMessageIsAppeared();
    }
}
