package CardList;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CardListConsentCalls {


    public ArrayList<CardModel> cardListConsent(String token){
        RequestSpecification requestSpecificationCardPost= APICardList.cardListRequest(token);
        Response response= (Response) requestSpecificationCardPost
                .post();
        response.then().spec(APICardList.cardListResponse());


          ArrayList<CardModel> cardDetailsList= new ArrayList<>();

        for (int i = 0; i < response.jsonPath().getList("Result").size(); i++){
            LinkedHashMap<String, Object> cardList= (LinkedHashMap<String, Object>) response.jsonPath().getList("Result").get(i);
            CardModel card= new CardModel();
            card.setCardNumber(cardList.get("CardNumber").toString());
            card.setCardNickName(cardList.get("CardNickName").toString());
            cardDetailsList.add(card);
        }
        return cardDetailsList;
    }
}
