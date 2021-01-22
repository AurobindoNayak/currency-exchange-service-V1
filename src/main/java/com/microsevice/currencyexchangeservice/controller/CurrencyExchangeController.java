package com.microsevice.currencyexchangeservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microsevice.currencyexchangeservice.entity.ExchangeValue;
import com.microsevice.currencyexchangeservice.repository.CurrencyExchangeRepositiory;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepositiory repo;
	
	@Autowired
	private Environment env;
	
	@PostMapping("/add")
	public ExchangeValue saveAll(@RequestBody ExchangeValue exchangeValue) {
		return repo.save(exchangeValue);
	}
	

	@GetMapping("/get/from/{from}/to/{to}")
	public ExchangeValue getExchangeAmount(@PathVariable String from, @PathVariable String to) {
		ExchangeValue ev=  repo.findByFromAndTo(from, to);
		ev.setPort(Integer.parseInt(env.getProperty("server.port")));
		return ev;
	}

}
