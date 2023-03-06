package com.heritage.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.loans.config.LoanProperties;
import com.heritage.loans.models.Customer;
import com.heritage.loans.models.Loan;
import com.heritage.loans.models.Properties;
import com.heritage.loans.repository.LoanRepository;

@RestController
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private LoanProperties loanProperties;
	
	@GetMapping("/loans")
	public List<Loan> getAccounts() {
		return loanRepository.findAll();
	}
	
	@PostMapping("/myLoans")
	public List<Loan> getLoansDetails(@RequestBody Customer customer) {
		List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDate(customer.getCustomerId());
		
		if (loans == null) {
			return null;
		}
		return loans;
	}

	@GetMapping("/loan/properties")
	public Properties fetchLoanProperties() {
		return loanProperties.getLoanProperties();
	}
}
