package TotalAmountInCurrency;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TotalAmountInCurrencyConsentCalls {

    public ArrayList<TotalAmountInCurrencyModel> totalAmountInCurrencyConsent(String token, String AccountNum) {
        RequestSpecification requestSpecificationInCurrency = APITotalAmountsInCurrencyTerms.totalAmountRequest(token);
        Response response = (Response) requestSpecificationInCurrency
                .post();
        response.then().spec(APITotalAmountsInCurrencyTerms.totalAmountResponse());
        ArrayList<TotalAmountInCurrencyModel> AmountInCurrencyList = new ArrayList<>();
        for (int i = 0; i < response.jsonPath().getList("Result").size(); i++) {
            LinkedHashMap<String, Object> AmountList = (LinkedHashMap<String, Object>) response.jsonPath().getList("Result").get(i);
            TotalAmountInCurrencyModel modelOfCurrency=new TotalAmountInCurrencyModel();
            if (AmountList.get("AccountNumber").toString().equals(AccountNum)) {
                modelOfCurrency.setCurrency(AmountList.get("Currency").toString());
                modelOfCurrency.setBalance(Double.parseDouble(AmountList.get("Balance").toString()));
                modelOfCurrency.setAccountNumber(AmountList.get("AccountNumber").toString());
                AmountInCurrencyList.add(modelOfCurrency);
            }

        }return AmountInCurrencyList;

    }

}
