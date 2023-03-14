package com.heritage.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.loans.config.LoanProperties;
import com.heritage.loans.models.Card;
import com.heritage.loans.models.Customer;
import com.heritage.loans.models.Loan;
import com.heritage.loans.models.Properties;
import com.heritage.loans.repository.LoanRepository;
import com.heritage.loans.service.client.CardsFeignClient;

@RestController
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private LoanProperties loanProperties;
	@Autowired
	private CardsFeignClient cardsFeignClient;
	
	@GetMapping("/getAllLoans")
	public List<Loan> getLoans(@RequestHeader("bank-trace-id") String traceId) {
		return loanRepository.findAll();
	}
	
	@PostMapping("/myLoans")
	public List<Loan> getLoansDetails(
			@RequestHeader("bank-trace-id") String traceId,
			@RequestBody Customer customer) {
		List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDate(customer.getCustomerId());
		
		if (loans == null) {
			return null;
		}
		return loans;
	}

	@GetMapping("/loan/properties")
	public Properties fetchLoanProperties(@RequestHeader("bank-trace-id") String traceId) {
		return loanProperties.getLoanProperties();
	}
	
	
	/**
	 * use Retry pattern for resiliency
	 * @param customer
	 * @return
	 */
	@PostMapping("/makePayment")
	public String makeLoanPayment(
			@RequestHeader("bank-trace-id") String traceId,
			@RequestBody Customer customer) {
		List<Card> cards = cardsFeignClient.getCardDetails(traceId, customer);
		
		// some business logic here
		
		
		if (cards.isEmpty()) {
			return "Payment unsuccessfull";
		}
		
		return "Payment successfully completed";
	}
}
