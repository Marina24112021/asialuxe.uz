package api.searchTicket;

import api.models.searchTicket.SearchTicketDirectionsModel;
import api.models.searchTicket.SearchTicketRequestModel;
import api.models.searchTicket.SearchTicketResponseModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.requestSpec;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.*;

public class SearchTicket {
    static final Random random = new Random();
    static final String dateDep = "2025-4-6";

    @Step("Создать POST запрос, для поиска билета. Данные о направлении и дате отправки")
    public static SearchTicketResponseModel getRequestID() {
        SearchTicketDirectionsModel directions = new SearchTicketDirectionsModel(
                "city",
                "city",
                "TAS",
                "IST",
                dateDep
        );
        SearchTicketRequestModel request = new SearchTicketRequestModel(0, 1,
                1, 0, 0, "E", "USD", 0,
                0, 0, 1, List.of(directions));
        return given(requestSpec)
                .body(request)
                .when()
                .post(SEARCH)
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(SearchTicketResponseModel.class);
    }

    @Step("Создать GET запрос, для получения данных о найденных билетах")
    public static String getCollectionOffers() {
        String buyId = null;
        Response response;
        SearchTicketResponseModel data = getRequestID();
        if (!data.getData().getRequest_id().isEmpty()) {
            do {
                response = given(requestSpec)
                        .when()
                        .get(GET_OFFERS + data.getData().getRequest_id() + GET_OFFERS_CR)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response();
                buyId = response.jsonPath().getString("data.data[0].buy_id");
            } while (buyId == null || response.jsonPath().getString("data.data[0].buy_id").isEmpty());
        }
        return buyId;
    }
}
