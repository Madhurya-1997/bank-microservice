package com.heritage.loans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heritage.loans.models.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

	List<Loan> findByCustomerIdOrderByStartDate(Integer customerId);
}
