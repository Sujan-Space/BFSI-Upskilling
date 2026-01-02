package com.bfsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.model.Account;
import com.bfsi.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public Account getAccount(Long accountNumber) {
        return repository.findById(accountNumber).orElse(null);
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account deposit(Long accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.setBalance(account.getBalance() + amount);
        return repository.save(account);
    }

    public Account withdraw(Long accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.setBalance(account.getBalance() - amount);
        return repository.save(account);
    }

    
    public void delete(Long accountNumber) {
        
        repository.deleteById(accountNumber);
    }
}
