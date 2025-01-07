package tests.api.selectTariffToBookTicket;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import tests.api.models.BookTicketRequestModel;
import tests.api.models.CheckTariffModel;
import tests.api.models.components.PassengersComponent;
import tests.api.searchPanel.SearchTicket;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static tests.helpers.ReadFileToList.readSecretFiles;
import static tests.specs.CodeAsiaLuxeSpec.requestSpec;
import static tests.specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static tests.specs.Endpoints.*;

public class SelectTariff {

    public static String getTariff() {
        String buyIdOfTicket = SearchTicket.getCollectionOffers();
        Response responseTariff = step("Создать GET запрос, получить список предлагаемыз тарифов для билета {buyIdOfTicket}", () ->
                given(requestSpec)
                        .when()
                        .get(GET_TARIFF + buyIdOfTicket)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
        return responseTariff.jsonPath().getString("data[0].buy_id");
    }

    public static String checkReservationID() {
        String buyId = SelectTariff.getTariff();
        CheckTariffModel request = new CheckTariffModel(1, buyId);
        Response response = step("Создать POST запрос, для предварительного бронирования билета {buyId}", () ->
                given(requestSpec)
                        .body(request)
                        .when()
                        .post(CHECK)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
        return response.jsonPath().getString("data.reservation_id");
    }

    @Step("Подготовить request body для бронирования билета. Данные о пассажире и тарифе.")
    private static BookTicketRequestModel getBookTicketRequestModel(String reservation_id)  {

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

    public static String bookTicket() {
        String reservation_id = checkReservationID();
        BookTicketRequestModel request = getBookTicketRequestModel(reservation_id);
        Response response = step("Создать POST запрос, для бронирования билета", () ->
                given(requestSpec)
                        .body(request)
                        .when()
                        .post(BOOK)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
        return response.jsonPath().getString("data.id");
    }
}
