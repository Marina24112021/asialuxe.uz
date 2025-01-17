package tests.web;

import helpers.extensions.WithLogin;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CustomToursPage;

import static api.bookTour.BookTour.getURLToBookTour;
import static io.qameta.allure.Allure.step;

@Owner("Marina Chen")
@Tag("smoke")
public class CustomToursTest extends TestBase {
    CustomToursPage customToursPage = new CustomToursPage();

    @Test
    @DisplayName("Требование авторизации при бронировании тура без входа в систему")
    public void checkMessageIsDisplayedIfUserUnauthorizedTest() {
        customToursPage.openTour("/ru/custom-tours/500")
                .clickOnBookTour()
                .checkTexts("Уважаемый клиент, " +
                        " Для бронирования, вам не обходимо войти в систему для безопасной транзакции");
    }


    @Test
    @WithLogin
    @DisplayName("Негативный тест  по бронированию тура. Тест содержит UI+API autotests")
    @Tag("smoke")
    @Tag("api")
    public void checkBookingTourTest() {
        String linkToBookTour = getURLToBookTour();
        step("Открыть собранный URL для бронирования тура", () -> customToursPage.openTour(linkToBookTour));
        step("Заполнить данные пассажира", () -> {
            customToursPage.setFullName()
                    .setEmail()
                    .setPhoneNum()
                    .setLastName()
                    .setName()
                    .setBirthday()
                    .setGender()
                    .setCitizenship()
                    .setPassportNum()
                    .setPassportExpiration();
        });
        step("Закрыть календарь", () -> customToursPage.closeCalender());
        step("Согласиться с политикой авиакомпании", () -> customToursPage.checkThePolicy());
        step("Нажать на Забронировать", () -> customToursPage.bookTour());
        step("Запустить скрипт по заморозке сообщения об ошибке", () -> customToursPage.runScriptToFrozenAlertMessage());
        step("Появилось сообщение об ошибке валидации", () -> customToursPage.getSuccessMessage());
    }
}
