package TotalAmountInCurrency;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class APITotalAmountsInCurrencyTerms {
    private static String baseUrl = "http://test.api.css.credo.ge";

    public static RequestSpecification totalAmountRequest(String token){
        return given()
                .baseUri(baseUrl)
                .basePath("/api/Account/AccountList")
                .headers("Authorization", token)
                .contentType("application/json")
                .body("{\"PersonId\": 2893448, \"ExcludeBalace\": false}");
    }
    public static ResponseSpecification totalAmountResponse(){
        return (ResponseSpecification) new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }

}
