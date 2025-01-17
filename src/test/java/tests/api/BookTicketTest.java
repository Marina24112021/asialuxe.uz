package tests.api;

import api.bookTicket.ListOfBookingTickets;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.bookTicket.BookTicket.bookTicket;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Owner("Marina Chen")
@Tag("api")
public class BookTicketTest {
    @Test
    @DisplayName("Проверка по созданию нового заказала-брони и наличие брони в заказах пользователя. Реализовано через API")
    void positiveCreateNewOrderAndCompareItWithResultListTest() {
        String newOrderId = step("Получить Id брони", () -> bookTicket().jsonPath().getString("data.id"));
        String expectedListOfOrderIdWithNewOrderId = step("Получить полный список Ids броней", ListOfBookingTickets::getListOfOrders);
        step("Id новой брони успешно обнаружен в списке", () -> assertTrue(expectedListOfOrderIdWithNewOrderId.contains(newOrderId)));
    }
}
