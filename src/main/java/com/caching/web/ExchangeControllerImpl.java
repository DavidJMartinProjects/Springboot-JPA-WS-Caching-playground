package com.caching.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caching.business.ExchangeService;
import com.caching.domain.ExchangeRates;

@RestController
public class ExchangeControllerImpl {
	
	@Autowired
	ExchangeService exchangeService;
	
	private Logger logger = LoggerFactory.getLogger(ExchangeControllerImpl.class);
	
	@GetMapping
	public ResponseEntity<String> ExchangeMsg() {
		return new ResponseEntity<String>("Welcome to ExchangeRates Service", HttpStatus.OK);	
	}

	@GetMapping("/rates")
	public ResponseEntity<ExchangeRates> getExchangeRates() {
		logger.info("getExchangeRates() : recieved request for latest exchange rates.");
		return new ResponseEntity<ExchangeRates>(exchangeService.requestLatestExchangeRatesFromDb(), HttpStatus.OK);
	}

}
		