package tests.web;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.selectTariffToBookTicket.BookingTicketAPIMethodsTest.bookTicket;
import static api.userProfile.UserProfile.getListOfOrders;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Marina Chen")
@Tag("api")
public class ProfileOrderAPITest {
    @Test
    @DisplayName("Проверка по созданию нового заказала-брони и наличие брони в заказах пользователя. Реализовано через API.")
    void createNewOrderAndCompareItWithResultListTest() {
        String newOrderId = bookTicket().jsonPath().getString("data.id");
        String expectedListOfOrderIdWithNewOrderId = getListOfOrders();
        assertTrue(expectedListOfOrderIdWithNewOrderId.contains(newOrderId));
    }
}
