package demo.InternetBanking.controller;

import demo.InternetBanking.entity.BankAccountTransfer;
import demo.InternetBanking.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BankingRestController {
    @Autowired
    BankAccountService bankAccountService;

    @RequestMapping(value = "/transfer", method = POST)
    public Object transfer(@RequestBody BankAccountTransfer bankAccountTransfer) {
        Map<Object, Object> map = bankAccountService.transferMoney(bankAccountTransfer.getAccount1(),
                bankAccountTransfer.getAccount2(), bankAccountTransfer.getAmount(),bankAccountTransfer.getDescription());
        return map;
    }
}
