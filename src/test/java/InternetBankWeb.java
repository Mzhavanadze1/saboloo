import Config.BaseConfig;
import com.codeborne.selenide.Configuration;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Config.BaseConfig;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;


public class InternetBankWeb {





@Test
public  void LogInTest() throws SQLException, ClassNotFoundException, InterruptedException {
       open(BaseConfig.LoginPageUrl);
        Configuration.timeout=30000;
        AuthorizationSteps authorizationSteps=new AuthorizationSteps();
    authorizationSteps.login();
    authorizationSteps.cardsAndAccounts();
    authorizationSteps.blockAndUnblockCard();
    authorizationSteps.PinResetAndChangeCardPin();
    authorizationSteps.CardsNextAndPrevious();
    authorizationSteps.CardHolderName();






       authorizationSteps.TransferIn();

       authorizationSteps.getTransactionHistory();





}

}
