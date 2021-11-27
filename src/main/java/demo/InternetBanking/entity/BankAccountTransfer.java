package demo.InternetBanking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BankAccountTransfer {
    private String account1;
    private String account2;
    private double amount;
    private String description;

    public BankAccountTransfer(String account1, String account2, double amount, String description) {
        setAccount1(account1);
        setAccount2(account2);
        setAmount(amount);
        setDescription(description);
    }
}
