package com.heritage.accounts.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerDetails {
	private List<Loan> loans;
	private List<Card> cards;
	private List<Account> accounts;
}
