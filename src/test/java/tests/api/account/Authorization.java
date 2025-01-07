package tests.api.account;

import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;

import static io.restassured.RestAssured.given;
import static tests.specs.CodeAsiaLuxeSpec.requestSpecForAuth;
import static tests.specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static tests.specs.Endpoints.LOGIN;

public class Authorization {
    public static void userAuthorization() {
        AuthorizationRequestModel request = new AuthorizationRequestModel(System.getProperty("login"), System.getProperty("password"));
        given(requestSpecForAuth)
                .body(request)
                .when()
                .post(LOGIN)
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(AuthorizationResponseModel.class);
    }
}
