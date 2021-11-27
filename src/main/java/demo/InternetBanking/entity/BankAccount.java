package demo.InternetBanking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_owner")
    private String accountOwner;

    @Column(name = "balance")
    private double balance;

    @OneToMany(mappedBy = "account")
    private List<TransactionHistory> transactionList;
}
