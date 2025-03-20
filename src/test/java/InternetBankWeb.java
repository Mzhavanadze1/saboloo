import Config.BaseConfig;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;


public class InternetBankWeb {


    @Test
    public void LogInTest() throws SQLException, ClassNotFoundException, InterruptedException {
        open(BaseConfig.LoginPageUrl);
        Configuration.timeout = 30000;
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.login();
        authorizationSteps.cardsAndAccounts();
        authorizationSteps.blockAndUnblockCard();
        authorizationSteps.PinResetAndChangeCardPin();
        authorizationSteps.CardsNextAndPrevious();
        authorizationSteps.CardHolderName();
        authorizationSteps.amountInCurrency();


//       authorizationSteps.TransferIn();
//
//       authorizationSteps.getTransactionHistory();


    }

}
