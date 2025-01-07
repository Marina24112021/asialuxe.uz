package tests.api.account;

import tests.api.models.AuthorizationRequestModel;
import tests.api.models.AuthorizationResponseModel;

import java.util.List;

import static io.restassured.RestAssured.given;
import static tests.helpers.ReadFileToList.readSecretFiles;
import static tests.specs.CodeAsiaLuxeSpec.requestSpecForAuth;
import static tests.specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static tests.specs.Endpoints.LOGIN;

public class Authorization {
    public static void userAuthorization() {
        List<String> credentials = readSecretFiles("credentialsasialuxe");
        System.out.println(credentials.get(0));
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
