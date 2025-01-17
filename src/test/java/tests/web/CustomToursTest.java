package tests.web;

import helpers.extensions.WithLogin;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CustomToursPage;

import static io.qameta.allure.Allure.step;

@Owner("Marina Chen")
@Tag("smoke")
public class CustomToursTest extends TestBase {
    CustomToursPage customToursPage = new CustomToursPage();

    @Test
    @DisplayName("Сообщение о требовании авторизации отображается, если пользователь хочет забронировать тур")
    public void checkMessageIsDisplayedIfUserUnauthorizedTest() {
        customToursPage.openTourPage(500)
                .clickOnBookTour()
                .checkTexts("Уважаемый клиент, " +
                        " Для бронирования, вам не обходимо войти в систему для безопасной транзакции");
    }

    @Test
    @WithLogin
    @DisplayName("Бронирование тура")
    public void checkBookingTourTest() {
        customToursPage
                .openTourPage(497)
                .clickOnBookTour();
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
        step("Согласиться с политикой авиакомпании", () -> customToursPage.checkThePolicy());
        step("Сообщение об успешной брони отобразилось ", () -> customToursPage.getSuccessMessage());
    }
}
