package com.heritage.accounts.models;

import java.time.LocalDate;

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
@ToString
@NoArgsConstructor
public class Account {


	@Column(name = "customer_id")
	private Integer customerId;
	@Id
	@Column(name = "account_number")
	private Long accountNumber;
	@Column(name = "account_type")
	private String accountType;
	@Column(name ="branch_address")
	private String branchAddress;
	@Column(name = "creation_date")
	private LocalDate creationDate;
}
