package demo.InternetBanking.service;

import demo.InternetBanking.entity.BankAccount;
import demo.InternetBanking.entity.TransactionHistory;
import demo.InternetBanking.repository.BankAccountRepository;
import demo.InternetBanking.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    TransactionHistoryRepository historyRepository;

    public BankAccount findByAccountNumber (String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber);
    }

    @Transactional
    public Map<Object, Object> transferMoney(String account1, String account2, double amount, String description) {
        Map<Object,Object> map = new LinkedHashMap<>();
        BankAccount accountOne = bankAccountRepository.findByAccountNumber(account1);
        BankAccount accountTwo = bankAccountRepository.findByAccountNumber(account2);

        if (account1.equals(account2)) {
            map.put("isValid", false);
        }

        if (accountOne == null || accountTwo == null) {
            map.put("isValid", false);
            return map;
        }

        double accountOneBalance = accountOne.getBalance();
        double accountTwoBalance = accountTwo.getBalance();

        if (accountOneBalance < amount) {
            map.put("isValid", false);
            return map;
        } else {
            accountOneBalance = accountOneBalance - amount;
            accountTwoBalance = accountTwoBalance + amount;
            accountOne.setBalance(accountOneBalance);
            accountTwo.setBalance(accountTwoBalance);
            bankAccountRepository.save(accountOne);
            bankAccountRepository.save(accountTwo);

            TransactionHistory history1 = new TransactionHistory();
            history1.setAccount(accountOne);
            history1.setAmount(0 - amount);
            history1.setDescription(description);
            history1.setTransactionDate(Date.valueOf(LocalDate.now()));
            historyRepository.save(history1);

            TransactionHistory history2 = new TransactionHistory();
            history2.setAccount(accountTwo);
            history2.setAmount(amount);
            history2.setDescription(description);
            history2.setTransactionDate(Date.valueOf(LocalDate.now()));
            historyRepository.save(history2);

            map.put("isValid", true);
            return map;
        }
    }
}
