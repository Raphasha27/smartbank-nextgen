package com.banking.smartbanknextgen.controller;

import com.banking.smartbanknextgen.model.*;
import com.banking.smartbanknextgen.service.BankingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BankingController {
    private final BankingService service;

    public BankingController(BankingService service) { this.service = service; }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.createCustomer(req.get("firstName"), req.get("lastName"), req.get("email")));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> listCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> openAccount(@RequestBody Map<String, Object> req) {
        return ResponseEntity.ok(service.openAccount((String)req.get("customerId"), (String)req.get("type"), (String)req.get("currency")));
    }

    @GetMapping("/customers/{id}/accounts")
    public ResponseEntity<List<Account>> getAccounts(@PathVariable String id) {
        return ResponseEntity.ok(service.getAccounts(id));
    }

    @PostMapping("/transactions/transfer")
    public ResponseEntity<?> transfer(@RequestBody Map<String, Object> req) {
        try {
            return ResponseEntity.ok(service.transfer(
                (String)req.get("fromAccountId"), (String)req.get("toAccountId"),
                new BigDecimal(req.get("amount").toString()), (String)req.get("description")));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/accounts/{id}/transactions")
    public ResponseEntity<List<Transaction>> getHistory(@PathVariable String id) {
        return ResponseEntity.ok(service.getHistory(id));
    }

    @PostMapping("/loans")
    public ResponseEntity<Loan> applyLoan(@RequestBody Map<String, Object> req) {
        return ResponseEntity.ok(service.applyForLoan(
            (String)req.get("customerId"), new BigDecimal(req.get("amount").toString()),
            new BigDecimal(req.get("interestRate").toString()), (int)req.get("termMonths")));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "smartbank-nextgen"));
    }
}
