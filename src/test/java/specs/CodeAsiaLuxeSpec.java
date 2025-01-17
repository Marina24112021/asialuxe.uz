package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class CodeAsiaLuxeSpec {
    public final static ResponseSpecification successfulResponse200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();
    public final static ResponseSpecification failResponse402Spec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(ALL)
            .build();
    // static Properties secretToken;
    public final static RequestSpecification requestSpecForAuth = with()
            .baseUri("https://api.asialuxe.app")
            .header("Authorization", "Bearer oqO7ALyHbi41BKJ-7QJ7PXLa59P1LEGmQp0UlkWCunsqqsQvz_1a5jFKRvHM_anc")
            // .header("Authorization", secretToken.getProperty("pathauth"))
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();
    public final static RequestSpecification requestSpec = with()
            .baseUri("https://api.asialuxe.app")
            .header("Authorization", "")
            // .header("Authorization", secretToken.getProperty("path"))
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();

   /* static {
        try {
            secretToken = readSecretFiles(SECRET_FILE_PATH_FOR_AUTHORIZATION);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
