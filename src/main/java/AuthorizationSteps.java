import CardList.CardListConsentCalls;
import CardList.CardModel;
import Config.BaseConfig;
import TotalAmountInCurrency.TotalAmountInCurrencyConsentCalls;
import TotalAmountInCurrency.TotalAmountInCurrencyModel;
import Transaction.TransactionConsentCalls;
import Transaction.TransactionModel;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static java.lang.Thread.sleep;


public class AuthorizationSteps extends LoginPageElements {
    public String Token;


    public void login() {
        UserName.sendKeys(BaseConfig.UserName);
        Password.click();
        Password.sendKeys(BaseConfig.Password);
        LogInBtn.click();
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


    }

    public void TransferIn() throws InterruptedException {
        TransferBtn.click();
        TransferHeader.scrollTo();
        InnerTransferBtn.click();
        TransferTo.shouldBe(Condition.visible);
        TransferTo.click();
        AccountItem.shouldBe(Condition.visible);
        AccountItem.click();
        ChooseAccount.click();
        Random random = new Random();
        Double AmountRan = random.nextDouble(Double.valueOf(0.01), Double.valueOf(0.3));
        MoneyInput.setValue(AmountRan.toString());
        MoneyTransferBtn.click();
        SuccessTransfer.shouldBe(Condition.visible);
        sleep(2000);


    }


    public void CardHolderName() throws SQLException, ClassNotFoundException {
        Products.click();
        Cards.click();
        ChooseCard.shouldBe(Condition.visible);
        ChooseCard.click();
        QueryOfSql queryOfSql = new QueryOfSql();
        this.Token = queryOfSql.getToken();
        CardListConsentCalls consentCalls = new CardListConsentCalls();
        ArrayList<CardModel> cardList = consentCalls.cardListConsent(this.Token);
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getCardNumber().equals(CardNumber.text())) {
                CardName.shouldBe(Condition.text(cardList.get(i).getCardNickName()));
                System.out.println(cardList.get(i).getCardNickName());
                System.out.println(cardList.get(i).getCardNumber());
            }


        }


    }

    public void amountInCurrency() throws SQLException, ClassNotFoundException {
        TotalAmountInCurrencyConsentCalls totalAmountInCurrencyConsentCalls = new TotalAmountInCurrencyConsentCalls();
        QueryOfSql queryOfSql = new QueryOfSql();
        this.Token = queryOfSql.getToken();
        ArrayList<TotalAmountInCurrencyModel> currencyList = totalAmountInCurrencyConsentCalls.totalAmountInCurrencyConsent(this.Token, Account.text());

        double sum = 0.00;
        String totalCurrencySym = "₾";
        for (int i = 0; i < currencyList.size(); i++) {
            String CurrencyCode= currencyList.get(i).getCurrency();
            String CurrencySym = "";
            double balance=0.00;
            try {
                balance = Double.parseDouble(currencyList.get(i).getBalance().toString());
            }catch (Exception e){
                System.out.println("shecdoma debilo" + currencyList.get(i).getBalance());
            }
            System.out.println("valut"+ CurrencyCode + "Tanxa"+ balance);

            if (CurrencyCode.equalsIgnoreCase("GEL")) {
                CurrencySym="₾";
                AmountInGel.shouldBe(Condition.text(String.format("%.2f", balance) + CurrencySym));
                sum += balance;
            }else if (CurrencyCode.equalsIgnoreCase("USD")) {
                CurrencySym = "$";
                AmountInDollar.shouldBe(Condition.text(String.format("%.2f", balance) + CurrencySym));
                sum += balance * 2.816;
            }else {
                System.out.println("ucnobi valuta"+CurrencyCode);
            }

////            String CurrencySym = "";
//            String totalCurrencySym= "₾";
//            if (currencyList.get(i).getCurrency().equalsIgnoreCase("GEL")) {
//                CurrencySym = "₾";
//                AmountInGel.shouldBe(Condition.text(String.format("%.2f", currencyList.get(i).getBalance()) + CurrencySym));
//                sum += Double.parseDouble(currencyList.get(i).getBalance().toString());
//
//            } else if (currencyList.get(i).getCurrency().equalsIgnoreCase("USD")) {
//                CurrencySym = "$";
//                AmountInDollar.shouldBe(Condition.text(String.format("%.2f", currencyList.get(i).getBalance()) + CurrencySym));
//                sum += Double.parseDouble(currencyList.get(i).getBalance().toString()) * 2.816;
//
//            }
        }
        TotalAmountInWeb.shouldBe(Condition.text(String.format("%.2f", sum) + " " + totalCurrencySym));
    }


    public void getTransactionHistory() throws SQLException, ClassNotFoundException {
        TransactionConsentCalls transactionConsentCalls = new TransactionConsentCalls();
        ArrayList<TransactionModel> transactionList = transactionConsentCalls.transactionConsent();
        Boolean TransactionExit = false;
        for (int i = 0; i < transactionList.size(); i++) {

            if (transactionList.get(i).getAccountNumber().equals(TransFromAcc.text()) &&
                    transactionList.get(i).getContragentAccount().equals(TransToAcc.text()) &&
                    transactionList.get(i).getAmount().equals((TransactionAmount.text()).split(" ")[0])) {

                TransactionExit = true;
                break;
            }
        }
        Assert.assertTrue(TransactionExit);

    }
}


















