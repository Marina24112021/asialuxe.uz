package helpers;

import static drivers.BrowserstackDriver.config;
import static io.restassured.RestAssured.given;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic(config.getUserName(), config.getAccessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .spec(successfulResponse200Spec)
                .extract().path("automation_session.video_url");
    }
}
