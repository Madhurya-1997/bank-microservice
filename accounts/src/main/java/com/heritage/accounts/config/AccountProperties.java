package com.heritage.accounts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.heritage.accounts.models.Properties;
import com.heritage.accounts.service.AccountConfig;


@Configuration
public class AccountProperties {

	
	@Autowired
	private AccountConfig accountsConfig;

	@Bean
	public Properties getAccountProperties() {
		Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
				accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
		return properties;
	}

}
