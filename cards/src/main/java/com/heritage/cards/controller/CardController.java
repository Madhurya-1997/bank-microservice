package com.heritage.cards.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.heritage.cards.models.Properties;
import com.heritage.cards.config.CardProperties;
import com.heritage.cards.models.Card;
import com.heritage.cards.models.Customer;
import com.heritage.cards.repository.CardRepository;

@RestController
public class CardController {
	
	private static final Logger logger = LoggerFactory.getLogger(CardController.class);


	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CardProperties cardProperties;
	
	@GetMapping("/cards")
	public List<Card> getAccounts(@RequestHeader("bank-trace-id") String traceId) {
		return cardRepository.findAll();
	}
	
	@PostMapping("/myCards")
	public List<Card> getCardDetails(
			@RequestHeader("bank-trace-id") String traceId,
			@RequestBody Customer customer) {
		logger.info("getCardDetails() method starts");
		List<Card> cards = cardRepository.findByCustomerId(customer.getCustomerId());
		
		if (cards == null) {
			logger.info("getCardDetails() method ends");
			return null;
		}
		
		logger.info("getCardDetails() method ends");
		return cards;
	}
	
	@GetMapping("/card/properties")
	public Properties fetchCardProperties() {
		return cardProperties.getCardProperties();
	}
}
