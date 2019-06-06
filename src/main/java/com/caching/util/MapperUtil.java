package com.caching.util;

import org.springframework.stereotype.Component;

import com.caching.domain.ExchangeRates;
import com.caching.respository.entity.ExchangeRatesEntity;

@Component
public class MapperUtil {		
		
	public ExchangeRates mapEntityToPojo(ExchangeRatesEntity exchangeRatesEntity) {
		ExchangeRates exchangeRates = new ExchangeRates();
		exchangeRates.setBase(exchangeRatesEntity.getBase());
		exchangeRates.setDate(exchangeRatesEntity.getDate());
		exchangeRates.setRates(exchangeRatesEntity.getRates());	
		return exchangeRates;			
	}	
	
	public ExchangeRatesEntity mapPojoToEntity(ExchangeRates exchangeRates) {
		ExchangeRatesEntity exchangeRatesEntity = new ExchangeRatesEntity();
		exchangeRatesEntity.setBase(exchangeRates.getBase());
		exchangeRatesEntity.setDate(exchangeRates.getDate());
		exchangeRatesEntity.setRates(exchangeRates.getRates());
		return exchangeRatesEntity;		
	}
	
}
		