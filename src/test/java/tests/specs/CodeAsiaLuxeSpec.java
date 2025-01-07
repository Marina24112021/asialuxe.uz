package tests.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static tests.helpers.CustomAllureListener.withCustomTemplates;

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
                    "Bearer accessEwm51_fR20Ik-0hSmAuCQDFfE6qKEgyP6raDqIimvKJ6CpOXHj8zVYD7nMEa7MpP1735925110_ALaggLc5mfN414Q-MWlNG-FyeAuTYvPmobile")
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();
    public final static ResponseSpecification successfulResponse200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

}
