package api.account;

import api.models.AuthorizationRequestModel;
import api.models.AuthorizationResponseModel;

import java.util.List;

import static helpers.ReadFileToList.readSecretFiles;
import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.requestSpecForAuth;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.LOGIN;

public class Authorization {
    public static void userAuthorization() {
        List<String> credentials = readSecretFiles("credentialsasialuxe");
        AuthorizationRequestModel request = new AuthorizationRequestModel(credentials.get(0), credentials.get(1));
        given(requestSpecForAuth)
                .body(request)
                .when()
                .post(LOGIN)
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(AuthorizationResponseModel.class);
    }
}
