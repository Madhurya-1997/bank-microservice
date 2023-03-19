package com.heritage.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heritage.accounts.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findByCustomerId(Integer customerId);
}
