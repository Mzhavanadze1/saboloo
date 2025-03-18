package Transaction;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APITransactions {
    LocalDateTime tenMinutesAgo = LocalDateTime.now().minus(10, ChronoUnit.MINUTES);
    public static String baseUrl="https://testtransactionapi.credo.ge";
    public static RequestSpecification getTransactionsRequest(){
        return given().baseUri(baseUrl)
                .basePath("/api/v1/transactions/2893448/last/")
                .header("Authorization","application/json")
                .param("inEng","false")
                //convert current timestamp - 10m to string format dd-mm-y hh:mm:ss
                .param("startDate","03-17-2024 12:28:12");
    }
    public static ResponseSpecification getTransactionsResponse(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }
}
