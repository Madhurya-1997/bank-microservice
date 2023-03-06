package com.heritage.cards.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heritage.cards.models.Properties;
import com.heritage.cards.service.CardConfig;


@Configuration
public class CardProperties {

	
	@Autowired
	private CardConfig cardsConfig;

	@Bean
	public Properties getCardProperties() {
		Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
				cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
		return properties;
	}

}
