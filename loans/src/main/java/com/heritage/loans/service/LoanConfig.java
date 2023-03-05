package com.heritage.loans.service;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Configuration
@ConfigurationProperties(prefix = "loans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanConfig {
	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;
	private List<String> activeBranches;
}

