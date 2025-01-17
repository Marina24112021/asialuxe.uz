package api.bookTour;

import api.models.prebookTour.PrebookTourRequestModule;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.*;
import static specs.Endpoints.BASE_URL_BOOK_TOUR;
import static specs.Endpoints.PREBOOK_TOUR;

public class BookTour {
    public static Response callPreBookTour() {
        PrebookTourRequestModule request = new PrebookTourRequestModule(
                1,
                1,
                0,
                "",
                "",
                "",
                "2025-01-30",
                "2025-02-06",
                null,
                "TAS",
                "HRI",
                "Цейлонский рай",
                "Эконом",
                false,
                false
        );
            return given(requestSpecForAuth)
                    .body(request)
                    .when()
                    .post(PREBOOK_TOUR)
                    .then()
                    .spec(successfulResponse200Spec)
                    .extract().response();

         }
    public static String getURLToBookTour(){
        Response response = callPreBookTour();
        return BASE_URL_BOOK_TOUR + "request_id=" + response.jsonPath().getString("data.data.reservation_id") +
                "type=1&adults=1&childs=0&tour_price=&avia_price=&total_price=&date_from=2025-01-30&date_to=2025-02-06&star&from=TAS&to=HRI&tour_name=Цейлонский+рай&class=Эконом&info_tour=false&umra_status=false";

    }
}
