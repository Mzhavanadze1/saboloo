package TotalAmountInCurrency;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TotalAmountInCurrencyConsentCalls {
    RequestSpecification requestSpecificationInCurrency= APITotalAmountsInCurrencyTerms.totalAmountRequest("token");

    public void totalAmountInCurrencyConsent(TotalAmountInCurrencyModel totalAmountInCurrencyModel){
        Response response= (Response) requestSpecificationInCurrency.body(totalAmountInCurrencyModel).post();
        response.then().spec(APITotalAmountsInCurrencyTerms.totalAmountResponse());
    }
}
