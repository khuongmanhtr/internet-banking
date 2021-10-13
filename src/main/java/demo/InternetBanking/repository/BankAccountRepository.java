package demo.InternetBanking.repository;

import demo.InternetBanking.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
    BankAccount findByAccountNumber(String accountNumber);
}
