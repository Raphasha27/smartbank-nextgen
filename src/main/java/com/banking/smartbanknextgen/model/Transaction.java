package com.banking.smartbanknextgen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "transactions")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fromAccountId;
    private String toAccountId;
    private BigDecimal amount;
    private String type;
    private String status = "PENDING";
    private String description;
    private LocalDateTime timestamp;

    public Transaction() {}
    public Transaction(String from, String to, BigDecimal amount, String type, String desc) {
        this.fromAccountId = from; this.toAccountId = to;
        this.amount = amount; this.type = type; this.description = desc;
        this.timestamp = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getFromAccountId() { return fromAccountId; }
    public String getToAccountId() { return toAccountId; }
    public BigDecimal getAmount() { return amount; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public String getDescription() { return description; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setStatus(String s) { this.status = s; }
}
