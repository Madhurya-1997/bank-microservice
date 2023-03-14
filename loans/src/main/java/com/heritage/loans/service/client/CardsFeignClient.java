package com.heritage.loans.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.heritage.loans.models.Card;
import com.heritage.loans.models.Customer;

@FeignClient(name = "cards")
public interface CardsFeignClient {
	
	@PostMapping("/myCards")
	List<Card> getCardDetails(
			@RequestHeader("bank-trace-id") String traceId, 
			@RequestBody Customer customer);

}
