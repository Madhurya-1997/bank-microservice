package com.heritage.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.heritage.accounts.config.AccountProperties;
import com.heritage.accounts.models.Account;
import com.heritage.accounts.models.Customer;
import com.heritage.accounts.models.Properties;
import com.heritage.accounts.repository.AccountRepository;
import com.heritage.accounts.service.AccountConfig;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private AccountProperties accountProperties;
	
	
	@GetMapping("/accounts")
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}
	
	@PostMapping("/myAccount")
	public List<Account> getAccountDetails(@RequestBody Customer customer) {
		List<Account> accounts = accountRepository.findByCustomerId(customer.getCustomerId());
		
		if (accounts == null) {
			return null;
		}
		return accounts;
	}
	
	@GetMapping("/account/properties")
	public Properties fetchAccountProperties() {
		return accountProperties.getAccountProperties();
	}
}
