package com.heritage.accounts.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
