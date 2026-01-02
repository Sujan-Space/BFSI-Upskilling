package com.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest
{
	private final AccountService service = new AccountService();
	@Test
	void shouldCalculateInterest()
	{
		double result = service.calculateInterest(10000);
		assertEquals(500,result);
	}
	@Test
	void shouldThrowExceptionForNegativeBalance()
	{
		assertThrows (IllegalArgumentException.class,()->service.calculateInterest(-1000));
	}
}
