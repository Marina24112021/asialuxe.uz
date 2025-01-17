package api.bookTicket;

import api.models.bookTicket.BookTicketRequestModel;
import api.models.bookTicket.CheckTariffModel;
import api.models.passangers.components.PassengersComponent;
import api.searchTicket.SearchTicket;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Collections;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.requestSpec;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.*;

@SuppressWarnings("SpellCheckingInspection")
public class BookTicket {

    public static Response getTariff() {
        String buyIdOfTicket = SearchTicket.getCollectionOffers();
        Response response = step("Создать GET запрос, получить список предлагаемых тарифов для выбранного билета", () ->
                given(requestSpec)
                        .when()
                        .get(GET_TARIFF + buyIdOfTicket)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
        if (response.jsonPath().getString("data[0].buy_id") == null) {
            return checkToReservationID(buyIdOfTicket);
        }
        return checkToReservationID(response.jsonPath().getString("data[0].buy_id"));
    }

    public static Response checkToReservationID(String buyIdOfTicket) {
        CheckTariffModel request = new CheckTariffModel(1, buyIdOfTicket);
        return step("Создать POST запрос, для предварительного бронирования билета", () ->
                given(requestSpec)
                        .body(request)
                        .when()
                        .post(CHECK)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
    }

    @Step("Подготовить request body для бронирования билета. Данные о пассажире и тарифе")
    private static BookTicketRequestModel getBookTicketRequestModel(String reservation_id) {
        PassengersComponent passengersComponent = new PassengersComponent(
                "ADT",
                "IVAN",
                "TRAFIMOV",
                null,
                null,
                "1958-11-11",
                "MALE",
                "UZB",
                "AD2971234",
                "2035-11-11",
                0,
                0
        );
        return new BookTicketRequestModel(
                "Trafimov Ivan Sergeevich",
                "ivan.trafimov@gmail.com",
                "+998908885005",
                reservation_id,
                1,
                "",
                Collections.singletonList(passengersComponent),
                Collections.emptyList(),
                "",
                ""
        );
    }

    public static Response bookTicket() {
        String reservation_id = getTariff().jsonPath().getString("data.reservation_id");
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
