package api.authorization;

import api.models.authorization.AuthorizationRequestModel;
import api.models.authorization.AuthorizationResponseModel;

import java.io.IOException;
import java.util.Properties;

import static helpers.ReadFileToList.readSecretFiles;
import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.requestSpecForAuth;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.LOGIN;
import static specs.Endpoints.SECRET_FILE_PATH_FOR_ASIALUXE;

public class Authorization {
    public static AuthorizationResponseModel userAuthorization() throws IOException {
        Properties credentials = readSecretFiles(SECRET_FILE_PATH_FOR_ASIALUXE);
        AuthorizationRequestModel request = new AuthorizationRequestModel(credentials.getProperty("login"), credentials.getProperty("password"));
        return given(requestSpecForAuth)
                .body(request)
                .when()
                .post(LOGIN)
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(AuthorizationResponseModel.class);
    }
}
