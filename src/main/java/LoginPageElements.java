import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public  class LoginPageElements {
    public SelenideElement UserName = $("#userName");
    public SelenideElement Password = $("#newPass");
    public SelenideElement LogInBtn = $("#submitAuth");
    public SelenideElement CloseFirstPopUpBtn = $x("/html/body/app-root/app-landing/app-main/div/div/section[2]/app-auth/app-popup-container/div/div/div[1]/div[2]");
    public SelenideElement CloseSecondPopUpBtn = $x("/html/body/app-root/app-home/div/div/app-main/app-popup-container/div/div/div[1]/div[2]");
    public SelenideElement OtpCodeInput = $("#otpCodeInput");
    public SelenideElement SendOtpBtn = $x("//*[@id='otpSend']/form/button");
    public SelenideElement SendOtpBtn2 = $x("//button[contains(text(),'დადასტურება')]");
    public SelenideElement CloseOtpBtn = $x("//button[contains(text(),'დახურვა')]");



    public SelenideElement FirstPopUpIsDisplayed = $x("//button[contains(text(),'გააქტიურება')]");
    public SelenideElement SecondPopUpIsDisplayed = $(".primary next");
    public SelenideElement UserMenuHeader = $(".user-menu-header");
    public SelenideElement ProductsHeader = $x("/html/body/app-root/app-home/div/div/app-products/div/div[1]/p");
    public SelenideElement CardsWithAccounts = $("#navToAccDetails");
    public SelenideElement AccountsHeader = $x("/html/body/app-root/app-home/div/div/app-accounts-and-cards-details/div/div[2]/div[1]/div[1]/p");

    public SelenideElement Products = $(".products");
    public SelenideElement Cards = $(".block-header-caps-20");
    public SelenideElement CloseBlockCardPopup = $x("/html/body/app-root/app-home/div/div/app-accounts-and-cards-details/app-popup-container/div/div/div[1]/div[2]");
    public SelenideElement ChooseCard = $(".paragraph-12");
    public SelenideElement AccountsSelectTo = $(".advanced-accounts-select");
    public SelenideElement ShowBlockOrUnblockCardPopup = $("#showBlockOrUnblockCardPopup");
    public SelenideElement CancelBlockCardPopup = $("#popupCard");
    public SelenideElement LockCard = $("#unblock");
    public SelenideElement SuccessPanel = $x("//*[contains(@class, 'success')]");
    public SelenideElement PinReset = $("#pinReset");
    public SelenideElement Transfer = $("#transfer");
    public SelenideElement CardName = $x("//div[contains(@id, 'accHasCard')]");
    public SelenideElement CardNumber = $x("//*[@id='accHasCard']/div/div[3]/div/p");
    public SelenideElement CancelPinReset = $("#closePinReset");
    public SelenideElement ChangeCardPin = $("#resetPin");

    public SelenideElement ScrollBtn = $x("//button[contains(text(),' დაკავშირებული ხარჯები ')]");
    public SelenideElement SelectNextCard=$("#selectNextProduct");
    public SelenideElement SelectPreviousCard= $("#selectPreviousProduct");
    public SelenideElement TransferBtn = $("#transfer");
    public SelenideElement InnerTransferBtn = $x("//div[contains(@class, 'transfer-type')]//div[contains(@class, 'txt')]//p");
    public SelenideElement InnerTransferHeader = $x("//div[contains(@class, 'header')]//p[contains(text(), 'საკუთარ ანგარიშზე გადარიცხვა')]");
    public SelenideElement TransferTo=$(".advanced-accounts-select");
    public SelenideElement AccountItem = $("#accountItem");
    public SelenideElement ChooseAccount = $(".account");
    public SelenideElement MoneyInput=$x("//div[contains(@class, 'custom-input-container')]//input[@name='amount']");
    public SelenideElement MoneyTransferBtn=$x("//button[contains(text(),'გადარიცხვა')]");
    public SelenideElement SuccessTransfer=$x("//div[contains(@class, 'payment-success-popup')]//p[contains(text(), ' გადარიცხვა წარმატებით შესრულდა ')]");
    public SelenideElement DownloadReq = $("#downloadRequisite");
    public SelenideElement TransferHeader=$x("//p[contains(text(),'გადარიცხვა')]");
    public SelenideElement TransFromAcc=$x("//div[p[1][contains(text(), 'საიდან')]]/p[2]");
    public SelenideElement TransToAcc=$x("//div[p[1][contains(text(), 'სად')]]/p[2]");
    public SelenideElement TransactionAmount=$x("//div[p[1][contains(text(), '0.01')]]/p[2]");









//
//
//
//
//

//

//
//    @FindBy(className = "paragraph-14")
//    public WebElement InnerTransfer;
//
//    @FindBy(className = "advanced-accounts-select custom-style")
//    public WebElement AccountsSelectFrom;
//

//
//    @FindBy(className = "ng-pristine ng-invalid ng-touched")
//    public WebElement Money;
//
//    @FindBy(className = "primary next")
//    public WebElement TransferBtn;
//
//    @FindBy(className = "payment-success-popup")
//    public WebElement PaymentSuccessPopup;
//
//    @FindBy(className = "icon close-black grey-010 pointer")
//    public WebElement ClosePaymentSuccessPopup;
//
//    @FindBy(className = "img home")
//    public WebElement Home;
}
