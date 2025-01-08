package tests.api.selectTariffToBookTicket;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import tests.api.models.BookTicketRequestModel;
import tests.api.models.CheckTariffModel;
import tests.api.models.components.PassengersComponent;
import tests.api.searchPanel.SearchTicket;

import java.util.Collections;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static tests.specs.CodeAsiaLuxeSpec.requestSpec;
import static tests.specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static tests.specs.Endpoints.*;

public class BookingTicketAPIMethodsTest {

    public static Response getTariff() {
        String buyIdOfTicket = SearchTicket.getCollectionOffers();
        return step("Создать GET запрос, получить список предлагаемыз тарифов для билета {buyIdOfTicket}", () ->
                given(requestSpec)
                        .when()
                        .get(GET_TARIFF + buyIdOfTicket)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
    }

    public static Response checkToReservationID() {
        String buyId = getTariff().jsonPath().getString("data[0].buy_id");
        CheckTariffModel request = new CheckTariffModel(1, buyId);
        return step("Создать POST запрос, для предварительного бронирования билета {buyId}", () ->
                given(requestSpec)
                        .body(request)
                        .when()
                        .post(CHECK)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
    }

    @Step("Подготовить request body для бронирования билета. Данные о пассажире и тарифе.")
    private static BookTicketRequestModel getBookTicketRequestModel(String reservation_id) {
        PassengersComponent passengersComponent = new PassengersComponent(
                "ADT",
                "ANN",
                "TSOY",
                null,
                null,
                "1990-11-11",
                "FEMALE",
                "UZB",
                "AD121212",
                "2025-12-12",
                0,
                0
        );
        return new BookTicketRequestModel(
                "Tsoy Ann Viktorovna",
                "tsoy.ann@gmail.com",
                "+998909190023",
                reservation_id,
                1,
                "",
                Collections.singletonList(passengersComponent),
                Collections.emptyList(),
                ""
        );
    }

    public static Response bookTicket() {
        String reservation_id = checkToReservationID().jsonPath().getString("data.reservation_id");
        BookTicketRequestModel request = getBookTicketRequestModel(reservation_id);
        return step("Создать POST запрос, для бронирования билета", () ->
                given(requestSpec)
                        .body(request)
                        .when()
                        .post(BOOK)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
    }
}
