package com.banking.smartbanknextgen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "loans")
public class Loan {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String customerId;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private int termMonths;
    private String status = "PENDING"; // PENDING, APPROVED, ACTIVE, PAID, DEFAULTED
    private LocalDateTime appliedAt;
    private LocalDateTime approvedAt;

    public Loan() {}
    public Loan(String customerId, BigDecimal amount, BigDecimal interestRate, int termMonths) {
        this.customerId = customerId; this.amount = amount;
        this.interestRate = interestRate; this.termMonths = termMonths;
        this.appliedAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getCustomerId() { return customerId; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getInterestRate() { return interestRate; }
    public int getTermMonths() { return termMonths; }
    public String getStatus() { return status; }
    public LocalDateTime getAppliedAt() { return appliedAt; }
    public LocalDateTime getApprovedAt() { return approvedAt; }
    public void setStatus(String s) { this.status = s; }
    public void setApprovedAt(LocalDateTime t) { this.approvedAt = t; }
}
