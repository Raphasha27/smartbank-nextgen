package com.banking.smartbanknextgen.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false) private String firstName;
    @Column(nullable = false) private String lastName;
    @Column(nullable = false, unique = true) private String email;
    private String phone;
    private boolean kycVerified;
    private LocalDateTime createdAt;

    public Customer() {}
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName; this.lastName = lastName; this.email = email;
        this.createdAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public boolean isKycVerified() { return kycVerified; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setKycVerified(boolean v) { this.kycVerified = v; }
    public void setPhone(String p) { this.phone = p; }
}
