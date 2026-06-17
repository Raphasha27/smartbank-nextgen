package com.banking.smartbanknextgen.service;

import com.banking.smartbanknextgen.model.*;
import com.banking.smartbanknextgen.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BankingService {
    private final CustomerRepository customerRepo;
    private final AccountRepository accountRepo;
    private final TransactionRepository transactionRepo;
    private final LoanRepository loanRepo;

    public BankingService(CustomerRepository cr, AccountRepository ar,
                          TransactionRepository tr, LoanRepository lr) {
        this.customerRepo = cr; this.accountRepo = ar;
        this.transactionRepo = tr; this.loanRepo = lr;
    }

    public Customer createCustomer(String first, String last, String email) {
        return customerRepo.save(new Customer(first, last, email));
    }

    public Account openAccount(String customerId, String type, String currency) {
        String num = "ACC-" + System.currentTimeMillis();
        return accountRepo.save(new Account(num, type, customerId, currency));
    }

    @Transactional
    public Transaction transfer(String fromId, String toId, BigDecimal amount, String desc) {
        Account from = accountRepo.findById(fromId).orElseThrow(() -> new RuntimeException("From account not found"));
        Account to = accountRepo.findById(toId).orElseThrow(() -> new RuntimeException("To account not found"));
        if (from.getBalance().compareTo(amount) < 0) throw new RuntimeException("Insufficient funds");
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));
        accountRepo.save(from); accountRepo.save(to);
        Transaction txn = new Transaction(fromId, toId, amount, "TRANSFER", desc);
        txn.setStatus("COMPLETED");
        return transactionRepo.save(txn);
    }

    public List<Transaction> getHistory(String accountId) {
        return transactionRepo.findByFromAccountIdOrToAccountIdOrderByTimestampDesc(accountId, accountId);
    }

    public Loan applyForLoan(String customerId, BigDecimal amount, BigDecimal rate, int months) {
        return loanRepo.save(new Loan(customerId, amount, rate, months));
    }

    public List<Customer> getAllCustomers() { return customerRepo.findAll(); }
    public List<Account> getAccounts(String customerId) { return accountRepo.findByCustomerId(customerId); }
}
