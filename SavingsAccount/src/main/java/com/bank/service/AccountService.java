package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        // Check if account already exists (FIRST CHECK)
        Account existingAccount = accountRepository.findByAccountNumber(account.getAccountNumber());
        if (existingAccount != null) {
            throw new IllegalArgumentException("Account already exists with account number: " + account.getAccountNumber());
        }
        
        // Validate that initial balance is not negative
        if (account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        
        return accountRepository.save(account);
    }

    public Account getAccountDetails(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found with account number: " + accountNumber);
        }
        return account;
    }

    @Transactional
    public Account depositMoney(String accountNumber, BigDecimal amount) {
        // Validate deposit amount
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found with account number: " + accountNumber);
        }

        // Add amount to balance
        BigDecimal newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);
        
        return accountRepository.save(account);
    }

    @Transactional
    public Account withdrawMoney(String accountNumber, BigDecimal amount) {
        // Validate withdrawal amount
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found with account number: " + accountNumber);
        }

        // Check for sufficient funds
        BigDecimal newBalance = account.getBalance().subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Insufficient funds. Current balance: " + account.getBalance() + ", Withdrawal amount: " + amount);
        }

        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    @Transactional
    public Account updateAccount(String accountNumber, Account updatedAccountData) {
        Account existingAccount = accountRepository.findByAccountNumber(accountNumber);
        if (existingAccount == null) {
            throw new IllegalArgumentException("Account not found with account number: " + accountNumber);
        }

        // Only update account holder name, not balance or account number
        existingAccount.setAccountHolderName(updatedAccountData.getAccountHolderName());
        
        return accountRepository.save(existingAccount);
    }
}