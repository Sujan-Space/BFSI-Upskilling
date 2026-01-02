package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountDetails(@PathVariable String accountNumber) {
        Account account = accountService.getAccountDetails(accountNumber);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Account> depositMoney(@PathVariable String accountNumber, @RequestParam BigDecimal amount) {
        Account updatedAccount = accountService.depositMoney(accountNumber, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Account> withdrawMoney(@PathVariable String accountNumber, @RequestParam BigDecimal amount) {
        Account updatedAccount = accountService.withdrawMoney(accountNumber, amount);
        return ResponseEntity.ok(updatedAccount);
    }
    @PutMapping("/{accountNumber}")
    public ResponseEntity<Account> updateAccount(@PathVariable String accountNumber, @Valid @RequestBody Account account) {
        Account existingAccount = accountService.getAccountDetails(accountNumber);

        if (existingAccount == null) {
            return ResponseEntity.notFound().build();  // Account not found
        }
         existingAccount.setAccountHolderName(account.getAccountHolderName());
        Account updatedAccount = accountService.createAccount(existingAccount);  
        return ResponseEntity.ok(updatedAccount);
    }
}
