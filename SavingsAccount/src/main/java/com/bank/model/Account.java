package com.bank.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "accountNumber"))
public class Account {

    @Id
    @NotBlank(message = "Account number cannot be blank")
    @Column(unique = true)
    private String accountNumber;

    @NotBlank(message = "Account holder name cannot be blank")
    private String accountHolderName;

    @NotNull(message = "Balance cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Balance cannot be negative")
    private BigDecimal balance;

    public Account() {}

    public Account(String accountNumber, String accountHolderName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}