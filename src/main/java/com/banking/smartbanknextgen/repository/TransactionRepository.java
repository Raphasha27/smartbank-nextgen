package com.banking.smartbanknextgen.repository;

import com.banking.smartbanknextgen.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByFromAccountIdOrToAccountIdOrderByTimestampDesc(String from, String to);
}
