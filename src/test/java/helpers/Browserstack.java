package helpers;

import java.io.IOException;
import java.util.Properties;

import static helpers.ReadFileToList.readSecretFiles;
import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;
import static specs.Endpoints.SECRET_FILE_PATH_FOR_BROWSERSTACK;

public class Browserstack {
    public static String videoUrl(String sessionId) throws IOException {
        Properties credentials = readSecretFiles(SECRET_FILE_PATH_FOR_BROWSERSTACK);
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic(credentials.getProperty("login"), credentials.getProperty("password"))
                .get(url)
                .then()
                .log().status()
                .log().body()
                .spec(successfulResponse200Spec)
                .extract().path("automation_session.video_url");
    }
}
