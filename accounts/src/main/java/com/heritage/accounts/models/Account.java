package com.heritage.accounts.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@JsonIgnoreProperties(
        value = {"creationDate"},
        allowGetters = true
)
public class Account implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "customer_id")
	private Integer customerId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_number")
	private Long accountNumber;
	@Column(name = "account_type")
	private String accountType;
	@Column(name ="branch_address")
	private String branchAddress;
	@Column(name = "creation_date")
	@CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDate creationDate;
}
