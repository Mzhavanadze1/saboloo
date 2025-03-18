package Transaction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class TransactionModel {
    public String contragentAccount;
    public String accountNumber;
    public String amount;//ინტერნეტბანკში დასამატებელია ღილაკები
}
