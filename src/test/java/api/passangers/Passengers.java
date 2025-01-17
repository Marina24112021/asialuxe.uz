package api.passangers;

import api.models.passangers.ListOfPassengersResponseModel;
import api.models.passangers.NewPassengerRequestModel;
import api.models.passangers.NewPassengerResponseModel;
import api.models.passangers.UpdatePassengerRequestModel;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.requestSpec;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.*;

public class Passengers {

    @Step("Запрос по созданию пассажира")
    public static NewPassengerResponseModel createPassenger() {
        Faker faker = new Faker();
        NewPassengerRequestModel request = new NewPassengerRequestModel(
                "ADT",
                faker.name().firstName(),
                faker.name().lastName(),
                "1990-9-9",
                "MALE",
                "UZB",
                "AD111111",
                "2026-9-9",
                1,
                "PASSPORT"
        );
        return given(requestSpec)
                .body(request)
                .when()
                .post(NEW_PASSENGER)
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(NewPassengerResponseModel.class);
    }

    @Step("Запрос по получению полного списка пассажиров")
    public static ListOfPassengersResponseModel getListOfPassengers() {
        return given(requestSpec)
                .when()
                .get(LIST_PASSENGERS)
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(ListOfPassengersResponseModel.class);
    }

    @Step("Запрос по удалению пассажира")
    public static Response deletePassenger(Integer newId, ResponseSpecification spec) {
        String deletePassengerPath = DELETE_UPDATE_PASSENGER + newId;
        return given(requestSpec)
                .when()
                .delete(deletePassengerPath)
                .then()
                .spec(spec)
                .extract().response();
    }

    @Step("Запрос по изменению данных о пассажире ")
    public static void updatePassenger(NewPassengerResponseModel response) {
        Faker faker = new Faker();
        UpdatePassengerRequestModel request = new UpdatePassengerRequestModel(
                "CHI",
                faker.name().firstName(),
                faker.name().lastName(),
                "2020-09-09",
                "MALE",
                "TUR",
                "TT444444",
                "2026-05-04",
                "PASSPORT",
                "",
                "",
                "",
                "",
                "",
                "",
                0,
                0,
                0,
                0,
                0,
                response.getData().getUser_id(),
                response.getData().getId()
        );
        given(requestSpec)
                .body(request)
                .when()
                .put(DELETE_UPDATE_PASSENGER + response.getData().getId())
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(NewPassengerResponseModel.class);
    }
}
