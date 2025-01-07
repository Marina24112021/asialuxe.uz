package tests.api.account;

import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static tests.helpers.ReadFileToList.readFile;
import static tests.specs.CodeAsiaLuxeSpec.requestSpecForAuth;
import static tests.specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static tests.specs.Endpoints.LOGIN;

public class Authorization {
    public static void userAuthorization() {
        List<String> credentials = null;
        try {
            credentials = readFile("credentialsasialuxe");
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        AuthorizationRequestModel request = new AuthorizationRequestModel(credentials.getFirst(), credentials.getLast());
        given(requestSpecForAuth)
                .body(request)
                .when()
                .post(LOGIN)
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(AuthorizationResponseModel.class);
    }
}
