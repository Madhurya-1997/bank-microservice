package com.heritage.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.cards.models.Properties;
import com.heritage.cards.config.CardProperties;
import com.heritage.cards.models.Card;
import com.heritage.cards.models.Customer;
import com.heritage.cards.repository.CardRepository;

@RestController
public class CardController {

	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CardProperties cardProperties;
	
	@GetMapping("/cards")
	public List<Card> getAccounts() {
		return cardRepository.findAll();
	}
	
	@PostMapping("/myCards")
	public List<Card> getCardDetails(@RequestBody Customer customer) {
		List<Card> cards = cardRepository.findByCustomerId(customer.getCustomerId());
		
		if (cards == null) {
			return null;
		}
		return cards;
	}
	
	@GetMapping("/card/properties")
	public Properties fetchCardProperties() {
		return cardProperties.getCardProperties();
	}
}
