package tests.web;

import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Marina Chen")
@Tag("smoke")
public class AsialuxeMainTest extends TestBase {
    final MainPage mainPage = new MainPage();
    final Faker faker = new Faker();
    @Test
    @DisplayName("Отображение сообщения при поиске билетов")
    void checkListOfTicketIsNotEmptyTest() {
        mainPage.openMainPage()
                .clickOnFieldWhere()
                .fillInputWhereFrom("Tashkent")
                .selectFirstValueWhereFrom()
                .fillInputWhereTo("Moskow")
                .selectFirstValueWhereTo()
                .removeAttr()
                .fillInputDate()
                .clickOnSearch()
                .checkMessageOfSearching()
                .blockShouldBeVisible();
        assertTrue(MainPage.collectionsAreNotEmpty() > 0);

    }

    @Test
    @DisplayName("Проверка текста в меню находящемся в хэдере сайта")
    public void checkTitlesOfHeaderMenuIsCorrectDisplayedOnMainPageTest() {
        mainPage.openMainPage()
                .checkTextInMenu("Авиа", "Отели", "Туры", "Чартеры", "Трансферы");
    }

    @Test
    @DisplayName("Сообщение о некорректном вводе данных авторизации")
    public void checkAlertIsAppearedIfCredentialsIsUncorrectedTest() {
        mainPage.openMainPage()
                .clickOnOpenLoginForm()
                .setLogin(faker.name().lastName())
                .setPassword(faker.internet().password())
                .clickOnLogin();
        mainPage.runScriptToFrozenAlertMessage();
        mainPage.checkAlertMessageIsAppeared();
    }

    @Test
    @DisplayName("Смена цвета поля Номер телефона при регистрации пользователя")
    public void checkInputIsColoredIfRegistrationFormIsEmptyTest() {
        mainPage.openMainPage()
                .clickOnOpenLoginForm()
                .clickOnRegistration();
        mainPage.setFullName(faker.name().fullName())
                .setEmail(faker.internet().emailAddress())
                .setPasswordRegistration(faker.internet().password());
        mainPage.clickOnRegistrationFromForm();
        mainPage.checkStyleOfInputPassword();
    }

    @Test
    @DisplayName("Сценарий Сброса пароля без подтверждения")
    public void checkResetPasswordTest() {
        mainPage.openMainPage()
                .clickOnOpenLoginForm()
                .clickOnPasswordReset()
                .setEmailReset(faker.internet().emailAddress())
                .clickReset()
                .runScriptToFrozenAlertMessage();
        mainPage.checkMessageToResetPassword();
    }
}
