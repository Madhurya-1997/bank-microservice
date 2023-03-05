package com.heritage.loans.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_number")
	private Integer loanNumber;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name="start_date")
	private Date startDate; // when a customer took the loan
	
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "total_loan")
	private Integer totalLoan;
	
	@Column(name = "amount_paid")
	private Integer amountPaid;
	
	@Column(name = "outstanding_amount")
	private Integer outstandingAmount;
	
	@Column(name = "creation_date")
	private String creationDate; // when the loan was first declared or first created
	

}
