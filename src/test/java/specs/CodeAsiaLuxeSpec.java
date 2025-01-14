package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class CodeAsiaLuxeSpec {
    public final static RequestSpecification requestSpecForAuth = with()
            .baseUri("https://api.asialuxe.app")
            .header("Authorization", "Bearer oqO7ALyHbi41BKJ-7QJ7PXLa59P1LEGmQp0UlkWCunsqqsQvz_1a5jFKRvHM_anc")
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();
    public final static RequestSpecification requestSpec = with()
            .baseUri("https://api.asialuxe.app")
            .header("Authorization",
                    "Bearer accessgSEylW0Yee99sq2un27l6_rRbHhkrm_fOqXOBzElnWlNR8SIH60jW0_3ztlxSekR1736846825Ki4mi2AWxnoVsYZxFDC5s3MbCTSSFlXEmobile")
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();
    public final static ResponseSpecification successfulResponse200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

}
