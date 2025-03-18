package CardList;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APICardList {
    private static String baseUrl = "http://test.api.css.credo.ge";

    public static RequestSpecification cardListRequest(String token) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PersonId", 2893448);
        jsonObject.put("AccountNumber",JSONObject.NULL);
        return given()
                .baseUri(baseUrl)
                .basePath("/api/Card/CardList")
                .headers("Authorization", token)
                .contentType("application/json")
                .body(jsonObject.toString());
    }

        public static ResponseSpecification cardListResponse(){
            return (ResponseSpecification) new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectContentType("application/json")
                    .build();
        }


    }

