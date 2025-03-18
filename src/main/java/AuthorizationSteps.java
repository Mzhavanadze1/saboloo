import CardList.CardListConsentCalls;
import CardList.CardModel;
import Config.BaseConfig;
import Transaction.TransactionConsentCalls;
import Transaction.TransactionModel;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.bouncycastle.pqc.jcajce.provider.sphincsplus.SignatureSpi;
import org.json.JSONObject;
import org.openqa.selenium.devtools.v133.filesystem.model.Directory;
import org.openqa.selenium.json.Json;
import org.testng.Assert;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class AuthorizationSteps extends LoginPageElements {
    public String Token;



    public void login() {
        UserName.sendKeys(BaseConfig.UserName);
        Password.click();
        Password.sendKeys(BaseConfig.Password);
        LogInBtn.click();
//        sleep(1000);
        OtpCodeInput.click();
        OtpCodeInput.sendKeys(BaseConfig.Otp);
        SendOtpBtn.click();


    }

    public void cardsAndAccounts() {

        FirstPopUpIsDisplayed.click();
        OtpCodeInput.sendKeys(BaseConfig.Otp);
        SendOtpBtn2.click();
        CloseOtpBtn.click();
        if (CloseSecondPopUpBtn.isDisplayed()) {
            CloseSecondPopUpBtn.click();
        }
        UserMenuHeader.shouldBe(Condition.visible);


        Products.click();
        ProductsHeader.shouldBe(Condition.visible);
        Cards.click();
        CardsWithAccounts.shouldBe(Condition.visible);


    }

    public void blockAndUnblockCard() {
        ChooseCard.click();
        AccountsHeader.shouldBe(Condition.visible);



        ShowBlockOrUnblockCardPopup.click();
        LockCard.shouldBe(Condition.visible);
        CancelBlockCardPopup.click();
        CancelBlockCardPopup.shouldNotBe(Condition.visible);

        ShowBlockOrUnblockCardPopup.click();
        LockCard.shouldBe(Condition.visible);
        CloseBlockCardPopup.click();
        CloseBlockCardPopup.shouldNotBe(Condition.visible);


        ShowBlockOrUnblockCardPopup.click();
        LockCard.shouldBe(Condition.visible);
        LockCard.click();
        SuccessPanel.shouldBe(Condition.visible);


    }

    public void PinResetAndChangeCardPin() {
        PinReset.shouldBe(Condition.visible);
        PinReset.click();
        CancelPinReset.shouldBe(Condition.visible);
        CancelPinReset.click();

        PinReset.shouldBe(Condition.visible);
        PinReset.click();
        CloseBlockCardPopup.click();

        PinReset.shouldBe(Condition.visible);
        PinReset.click();
        ChangeCardPin.click();
        OtpCodeInput.sendKeys(BaseConfig.Otp);
        SendOtpBtn2.click();
        SuccessPanel.shouldBe(Condition.visible);
    }

    public void CardsNextAndPrevious() {
        ScrollBtn.scrollTo();
        SelectNextCard.click();
        CardNumber.shouldHave(text("1638"));
        SelectPreviousCard.click();
        CardNumber.shouldHave(text("1072"));
       DownloadReq.click();
       Selenide.sleep(5000);
        File directory = new File("build/downloads");
        Assert.assertTrue(directory.listFiles()[0].listFiles()[0].getName().equals("Requisites.pdf"));

//       File DownloadFile= DownloadReq.download();
//       DownloadFile.getName().equals("Requisites.pdf");

    }

    public void TransferIn() {
        TransferBtn.click();
        TransferHeader.scrollTo();
        InnerTransferBtn.click();
        TransferTo.shouldBe(Condition.visible);
        TransferTo.click();
        AccountItem.shouldBe(Condition.visible);
        AccountItem.click();
        ChooseAccount.click();
        MoneyInput.setValue("0.01");
        MoneyTransferBtn.click();
        SuccessTransfer.shouldBe(Condition.visible);
        String TransferFrom=TransFromAcc.text();
        String TransferTo=TransToAcc.text();

    }


    public void CardHolderName() throws SQLException, ClassNotFoundException {
        Products.click();
        Cards.click();
        ChooseCard.shouldBe(Condition.visible);
        ChooseCard.click();
        QueryOfSql queryOfSql = new QueryOfSql();
        this.Token = queryOfSql.getToken();
        CardListConsentCalls consentCalls = new CardListConsentCalls();
        ArrayList <CardModel> cardList = consentCalls.cardListConsent( this.Token);
        for (int i = 0; i < cardList.size(); i++) {
            cardList.get(i).getCardNickName();
            if (cardList.get(i).getCardNumber().equals(CardNumber.text())){
                CardName.shouldBe(Condition.text(cardList.get(i).getCardNickName()));
                System.out.println(cardList.get(i).getCardNickName());
                System.out.println(cardList.get(i).getCardNumber());
            }


        }


    }
    public void getTransactionHistory() throws SQLException, ClassNotFoundException {
        TransactionConsentCalls transactionConsentCalls=new TransactionConsentCalls();
        ArrayList<TransactionModel> transactionList=transactionConsentCalls.transactionConsent();
        for (int i = 0; i < transactionList.size(); i++) {
            transactionList.get(i).getAmount();
            if(transactionList.get(i).getAmount().equals(TransactionAmount.text())){
                System.out.println(transactionList.get(i).getAmount());
                System.out.println(transactionList.get(i).getAccountNumber());
                System.out.println(transactionList.get(i).getContragentAccount());
            }


        }

    }



    }












