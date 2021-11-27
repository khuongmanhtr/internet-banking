package demo.InternetBanking.controller;

import demo.InternetBanking.entity.BankAccount;
import demo.InternetBanking.entity.TransactionHistory;
import demo.InternetBanking.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class BankingController {
    @Autowired
    BankAccountService bankAccountService;

    @RequestMapping("/")
    public String homepage () {
        return "homepage";
    }

    @RequestMapping(value = "/search", method = GET)
    public String searchByAccountNumber (@RequestParam("account") String bankAccount, Model model) {
        BankAccount account = bankAccountService.findByAccountNumber(bankAccount.trim());
        List<TransactionHistory> transactionHistoryList = account.getTransactionList();
        model.addAttribute("account", account);
        model.addAttribute("transactionHistoryList", transactionHistoryList);
        return "homepage";
    }
}
