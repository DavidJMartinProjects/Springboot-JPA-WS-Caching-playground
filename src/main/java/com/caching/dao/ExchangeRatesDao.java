package com.caching.dao;

import com.caching.respository.entity.ExchangeRatesEntity;

public interface ExchangeRatesDao {
	ExchangeRatesEntity getAllExchangeRatesFromDb();
	void saveExchangeRatesToDb(ExchangeRatesEntity exchangeRatesEntity);		
}
	