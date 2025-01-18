package tests.api;

import api.bookTicket.ListOfBookingTickets;

import io.qameta.allure.Owner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.bookTicket.BookTicket.bookTicket;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Owner("Marina Chen")
@Tag("api")
public class BookTicketTest {
    @Test
    @DisplayName("Проверка по получению полного списка броней пользователя")
    void positiveCreateNewOrderAndCompareItWithResultListTest() {
        step("Получить успешный статус по получению полного списка броней пользователя", () -> {
                    assertEquals("success",
                            ListOfBookingTickets.getListOfOrders().jsonPath().getString("message"));
        });
    }
    @Test
    @DisplayName("Негативный тест по проверке бронирования билета с невидными данными")
    void negativeIfDataOfPassengerIsIncorrect(){
        step("Отображается код ошибки и ошибка, а так же тип ошибки", () -> {
            assertEquals("Validation error!", bookTicket().getMessage());
        });

    }
}
