package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController
{
	private final AccountService service;
	public AccountController (AccountService service)
	{
		this.service = service;
	}
	@GetMapping("/{balance}")
	public double getInterest (@PathVariable double balance)
	{
		return service.calculateInterest(balance);
	}
}