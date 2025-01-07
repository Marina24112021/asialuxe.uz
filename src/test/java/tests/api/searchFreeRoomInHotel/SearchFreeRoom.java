package tests.api.searchFreeRoomInHotel;

import io.restassured.response.Response;
import tests.api.models.SearchFreeRoomRequestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static tests.specs.CodeAsiaLuxeSpec.requestSpec;
import static tests.specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static tests.specs.Endpoints.SEARCH_ROOM;

public class SearchFreeRoom {
    public static int findFreeRoomAPI(String hotelId) {
        List<Integer> children = new ArrayList<>(9);
        SearchFreeRoomRequestModel request = new SearchFreeRoomRequestModel(hotelId, "2025-03-28", "2025-03-31", "USD", 2, children, 2, "hotel", "ru", "", "no");
        Response response = given(requestSpec)
                .body(request)
                .when()
                .post(SEARCH_ROOM)
                .then()
                .spec(successfulResponse200Spec)
                .extract().response();
        List<Map<String, Object>> countOfRooms = response.jsonPath().getList("rooms");
        return countOfRooms.size();
    }
}
