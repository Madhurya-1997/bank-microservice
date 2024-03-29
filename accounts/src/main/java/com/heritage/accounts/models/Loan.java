package com.heritage.accounts.models;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Loan {
	private Integer loanNumber;
	private Integer customerId;
	private Date startDate; // when a customer took the loan
	private String loanType;
	private Integer totalLoan;
	private Integer amountPaid;
	private Integer outstandingAmount;
	private String creationDate; // when the loan was first declared or first created
}