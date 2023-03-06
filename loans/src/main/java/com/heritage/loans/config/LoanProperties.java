package com.heritage.loans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heritage.loans.models.Properties;
import com.heritage.loans.service.LoanConfig;

@Configuration
public class LoanProperties {

	
	@Autowired
	private LoanConfig loansConfig;

	@Bean
	public Properties getLoanProperties() {
		Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
				loansConfig.getMailDetails(), loansConfig.getActiveBranches());
		return properties;
	}

}
