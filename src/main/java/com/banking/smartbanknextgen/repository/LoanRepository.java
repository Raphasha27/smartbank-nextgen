package com.banking.smartbanknextgen.repository;

import com.banking.smartbanknextgen.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {
    List<Loan> findByCustomerId(String customerId);
    List<Loan> findByStatus(String status);
}
