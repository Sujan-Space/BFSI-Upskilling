package com.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Bank Account Details")
public class Account {
	@Schema(description = "unique Account Number",example="1001")
	private Long accountNumber;
  
	@Schema(description = "Account Holder Name ",example="Sujan")
	private String accountHolderName;
	
	@Schema(description = "Account Balance ",example="500000")
	private Double balance;


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Account() {
		super();
		
	}


	public Account(Long accountNumber, String accountHolderName, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	
	
	
	
}
