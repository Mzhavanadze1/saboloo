package TotalAmountInCurrency;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TotalAmountInCurrencyConsentCalls {

    public ArrayList<TotalAmountInCurrencyModel> totalAmountInCurrencyConsent(String token) {
        RequestSpecification requestSpecificationInCurrency = APITotalAmountsInCurrencyTerms.totalAmountRequest(token);
        Response response = (Response) requestSpecificationInCurrency
                .post();
        response.then().spec(APITotalAmountsInCurrencyTerms.totalAmountResponse());
        ArrayList<TotalAmountInCurrencyModel> AmountInCurrencyList = new ArrayList<>();
        for (int i = 0; i < response.jsonPath().getList("data").size(); i++) {
            LinkedHashMap<String, Object> AmountList = (LinkedHashMap<String, Object>) response.jsonPath().getList("data").get(i);
            TotalAmountInCurrencyModel modelOfCurrency=new TotalAmountInCurrencyModel();
            modelOfCurrency.setCurrency(AmountList.get("Currency").toString());
            modelOfCurrency.setBalance((Integer) AmountList.get("Balance"));
            modelOfCurrency.setAccNumberAvailableName(AmountList.get("AccNumberAvailableName").toString());
            AmountInCurrencyList.add(modelOfCurrency);

        }return AmountInCurrencyList;

    }

}
