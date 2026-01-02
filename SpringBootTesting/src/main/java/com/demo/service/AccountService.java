package com.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService
{
	public double calculateInterest(double balance)
	{
		if (balance<0)
		{
			throw new IllegalArgumentException("Invalid Balance");
		}
		return balance * 0.05;
	}

}