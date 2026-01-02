package com.bfsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfsi.model.Account;
import com.bfsi.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    // Create a new account
    @PostMapping
    public Account create(@RequestBody Account account) {
        return service.saveAccount(account);
    }

    // Get an account by account number
    @GetMapping("{accountNumber}")
    public Account getAccount(@PathVariable long accountNumber) {
        return service.getAccount(accountNumber);
    }

    // Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    // Deposit amount into an account
    @PutMapping("/{accountNumber}/deposit/{amount}")
    public Account deposit(@PathVariable Long accountNumber, @PathVariable double amount) {
        return service.deposit(accountNumber, amount);
    }

    // Withdraw amount from an account
    @PutMapping("/{accountNumber}/withdraw/{amount}")
    public Account withdraw(@PathVariable Long accountNumber, @PathVariable double amount) {
        return service.withdraw(accountNumber, amount);
    }

    
    @DeleteMapping("/{accountNumber}")
    public void delete(@PathVariable Long accountNumber) {
        service.delete(accountNumber); 
    }
}
