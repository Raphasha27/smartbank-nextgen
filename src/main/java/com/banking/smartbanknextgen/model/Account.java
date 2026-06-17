package com.banking.smartbanknextgen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "accounts")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true) private String accountNumber;
    private String accountType;
    private BigDecimal balance = BigDecimal.ZERO;
    private String currency;
    private String customerId;
    private boolean active = true;
    private LocalDateTime openedAt;

    public Account() {}
    public Account(String accountNumber, String accountType, String customerId, String currency) {
        this.accountNumber = accountNumber; this.accountType = accountType;
        this.customerId = customerId; this.currency = currency;
        this.openedAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public BigDecimal getBalance() { return balance; }
    public String getCurrency() { return currency; }
    public String getCustomerId() { return customerId; }
    public boolean isActive() { return active; }
    public LocalDateTime getOpenedAt() { return openedAt; }
    public void setBalance(BigDecimal b) { this.balance = b; }
    public void setActive(boolean a) { this.active = a; }
}
