package com.microsevice.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microsevice.currencyexchangeservice.entity.ExchangeValue;

@Repository
public interface CurrencyExchangeRepositiory extends JpaRepository<ExchangeValue, Integer> {
	
	public ExchangeValue save(ExchangeValue exchangeValue);
	 
	
	public ExchangeValue findByFromAndTo(String from, String to);

}
