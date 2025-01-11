package helpers;

import java.util.List;

import static drivers.BrowserstackDriver.config;
import static helpers.ReadFileToList.readSecretFiles;
import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        List<String> credentials = readSecretFiles("browserstackcredentionals");
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic(credentials.get(0), credentials.get(1))
                .get(url)
                .then()
                .log().status()
                .log().body()
                .spec(successfulResponse200Spec)
                .extract().path("automation_session.video_url");
    }
}
