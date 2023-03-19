package com.heritage.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heritage.accounts.models.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	
}