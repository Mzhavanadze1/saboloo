package Transaction;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TransactionConsentCalls {
    RequestSpecification requestSpecificationTransaction= APITransactions.getTransactionsRequest();
    public ArrayList <TransactionModel>  transactionConsent(){
        Response response=requestSpecificationTransaction
                .when()
                .get();
        response.then().spec(APITransactions.getTransactionsResponse());

        ArrayList<TransactionModel> transactionDetailsList= new ArrayList<>();
        for (int i = 0; i < response.jsonPath().getList("data").size(); i++) {
            LinkedHashMap<String, Object> transactionList= (LinkedHashMap<String, Object>) response.jsonPath().getList("data").get(i);
            TransactionModel transactionModel=new TransactionModel();
            transactionModel.setContragentAccount(transactionList.get("contragentAccount").toString());
            transactionModel.setAccountNumber(transactionList.get("accountNumber").toString());
            transactionModel.setAmount(transactionList.get("amount").toString());
            transactionDetailsList.add(transactionModel);

        }

        return transactionDetailsList;//რესპონსზე გადავიარო როგორც წინაშემთხვევაში ლისტში, აქვსე მაქვს, ორჯერ რომ არ გადავიარო ციკლი, აქ უნდა მივცე ორი ანგარიშის ნომერი, და რესფონზე გადავივლი ციკლი და შედარება გავაკეთო და პირდაპირ ისეთი ვიპოვო სადაც ანგარიშებია

    }
}
