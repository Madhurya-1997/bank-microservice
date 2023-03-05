package com.heritage.cards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heritage.cards.models.Card;


@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
	
	List<Card> findByCustomerId(Integer customerId);

}
