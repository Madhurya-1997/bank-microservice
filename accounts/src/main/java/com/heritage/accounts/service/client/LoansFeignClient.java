package com.heritage.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.heritage.accounts.models.Customer;
import com.heritage.accounts.models.Loan;


@FeignClient("loans")
public interface LoansFeignClient {
	@PostMapping("/myLoans")
	public List<Loan> getLoansDetails(
			@RequestHeader("bank-trace-id") String traceId, 
			@RequestBody Customer customer);
}
