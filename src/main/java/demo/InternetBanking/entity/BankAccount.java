package demo.InternetBanking.entity;

import javax.persistence.*;
import java.util.List;

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

    public BankAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionList;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionList) {
        this.transactionList = transactionList;
    }
}
