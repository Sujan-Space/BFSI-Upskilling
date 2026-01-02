package com.swagger.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.Account;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/accounts")
@Tag(name="Account Management API",description="API's for managing bank accounts in BFSI system")
public class AccountController {
	
      @PostMapping
      @Operation(summary="create New Account",description ="Create a new bank account with initial balance")
      public Account createAccount(@RequestBody Account account) {
    	  return account; //echo response
      }
      
      @GetMapping("/{accountNumber}")
      @Operation(summary="Get Account Details",description = "Fetch account details by account number")
      public Account getAccount(@PathVariable Long accountNumber) {
    	  return new Account(accountNumber,"Sujan Kumar",5000000.0);
      }
      
      @PutMapping("/{accountNumber}/credit")
      @Operation(summary="Credit amount ",description="Credit amount to account")
   
      public String creditAmount(@PathVariable Long accountNumber ,@RequestParam Double amount) {
    	  return "Amount" + amount + "credited to account " + accountNumber;
      }
      
      @DeleteMapping("/{accountNumber}")
      @Operation(summary="CLose Account",description="Closes account if balance is zero")
      public String deleteAccount(@PathVariable Long accountNumber) {
    	  return "Account" +  accountNumber + "closed successfully";
    	  }
      
}
