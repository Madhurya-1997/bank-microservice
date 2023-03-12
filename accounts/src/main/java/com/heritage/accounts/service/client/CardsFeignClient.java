package com.heritage.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.heritage.accounts.models.Card;
import com.heritage.accounts.models.Customer;

@FeignClient(name = "cards")
public interface CardsFeignClient {
	
	@PostMapping("/myCards")
	List<Card> getCardDetails(@RequestBody Customer customer);

}
