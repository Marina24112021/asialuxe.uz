package api.bookTicket;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.requestSpec;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.ORDER;

public class ListOfBookingTickets {
    @Step("Создать GET запрос, получить весь список заказов для бронирования")
    public static Response getListOfOrders() {
        return given(requestSpec)
                .when()
                .get(ORDER)
                .then()
                .spec(successfulResponse200Spec)
                .extract().response();
    }
}
