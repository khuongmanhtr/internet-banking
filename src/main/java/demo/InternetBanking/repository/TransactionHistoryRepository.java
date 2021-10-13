package demo.InternetBanking.repository;

import demo.InternetBanking.entity.TransactionHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory, Integer> {
}
