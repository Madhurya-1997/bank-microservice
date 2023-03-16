package com.heritage.accounts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.accounts.config.AccountProperties;
import com.heritage.accounts.models.Account;
import com.heritage.accounts.models.Card;
import com.heritage.accounts.models.Customer;
import com.heritage.accounts.models.CustomerDetails;
import com.heritage.accounts.models.Loan;
import com.heritage.accounts.models.Properties;
import com.heritage.accounts.repository.AccountRepository;
import com.heritage.accounts.service.client.CardsFeignClient;
import com.heritage.accounts.service.client.LoansFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	
	@Autowired
	AccountRepository accountRepository;

	@Autowired 
	private AccountProperties accountProperties;
	
	@Autowired
	private LoansFeignClient loansFeignClient;
	
	@Autowired
	private CardsFeignClient cardsFeignClient;
	
	
	@GetMapping("/getAllAccounts")
	public List<Account> getAccounts(@RequestHeader("bank-trace-id") String traceId) {
		return accountRepository.findAll();
	}
	
	@PostMapping("/myAccount")
	public List<Account> getAccountDetails(
			@RequestHeader("bank-trace-id") String traceId,
			@RequestBody Customer customer) {
		List<Account> accounts = accountRepository.findByCustomerId(customer.getCustomerId());
		
		if (accounts == null) {
			return null;
		}
		return accounts;
	}
	
	@GetMapping("/account/properties")
	public Properties fetchAccountProperties(@RequestHeader("bank-trace-id") String traceId) {
		return accountProperties.getAccountProperties();
	}
	
	
	/**
	 * get all customer details, i.e., cards,loans and account details
	 */
	@PostMapping("/myCustomerDetails")
	@CircuitBreaker(name = "myCustomerDetailsCB", fallbackMethod = "fallbackOnMyCustomerDetailsFailure")
	public CustomerDetails getCustomerDetails(
			@RequestHeader("bank-trace-id") String traceId,
			@RequestBody Customer customer) {
		
		logger.info("myCustomerDetails() method starts");
		List<Account> accounts = accountRepository.findByCustomerId(customer.getCustomerId());
		List<Loan> loans = loansFeignClient.getLoansDetails(traceId, customer);
		List<Card> cards = cardsFeignClient.getCardDetails(traceId, customer);
		
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		customerDetails.setCards(cards);
		
		logger.info("myCustomerDetails() method ends");
		return customerDetails;
	}
	
	@SuppressWarnings("unused")
	private CustomerDetails fallbackOnMyCustomerDetailsFailure(
			String traceId,
			Customer customer, 
			Throwable t) {
		return new CustomerDetails(t.getMessage());
	}
}
