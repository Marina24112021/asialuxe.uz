package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static tests.api.selectTariffToBookTicket.SelectTariff.bookTicket;
import static tests.api.userProfile.UserProfile.getListOfOrders;

@Owner("Marina Chen")
@Tag("api")
public class ProfileOrderAPITest {
    @Test
    @DisplayName("Проверка по созданию нового заказала-брони и наличие брони в заказах пользователя. Реализовано через API.")
    void createNewOrderAndCompareItWithResultList() throws IOException, URISyntaxException {
        String newOrderId = bookTicket();
        String expectedListOfOrderIdWithNewOrderId = getListOfOrders();
        assertTrue(expectedListOfOrderIdWithNewOrderId.contains(newOrderId));
    }
}
