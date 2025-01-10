package api.userProfile;

import api.models.components.DataOfOrdersComponent;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.requestSpec;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.ORDER;

public class UserProfile {
    public static String getListOfOrders() {
        Response response = step("Создать GET запрос, получить весь список заказов для бронирования", () ->
                given(requestSpec)
                        .when()
                        .get(ORDER)
                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().response());
        return getResponseToConcatenateOrderIdToString(response);
    }

    @Step("Получить все OrderId из полученного GET запроса и собрать в одну строку")
    public static String getResponseToConcatenateOrderIdToString(Response response) {
        StringBuilder orderIdString = new StringBuilder();
        List<DataOfOrdersComponent> listOrders = response.jsonPath().getList("data", DataOfOrdersComponent.class);
        for (DataOfOrdersComponent listOrder : listOrders) {
            Integer id = listOrder.getData().getId();
            orderIdString.append(id).append(" ");
        }
        return orderIdString.toString();
    }
}
