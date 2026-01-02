package com.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void shouldReturnInterest()throws Exception
	{
		mockMvc.perform(get("/api/accounts/10000")).andExpect(status().isOk()).andExpect(content().string("500.0"));
	}
	@Test
	void shouldFailForNegativeBalance() throws Exception
	{
		mockMvc.perform(get("/api/accounts/-1000")).andExpect(status().isBadRequest()).andExpect(content().string("Invalid Balance"));
		
	}
}
