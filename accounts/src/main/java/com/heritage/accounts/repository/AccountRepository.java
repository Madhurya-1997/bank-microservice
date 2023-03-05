package com.heritage.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heritage.accounts.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findByCustomerId(Integer customerId);
}
