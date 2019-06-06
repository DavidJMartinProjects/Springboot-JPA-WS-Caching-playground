package com.caching.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caching.respository.ExchangeRatesRespository;
import com.caching.respository.entity.ExchangeRatesEntity;

@Component	
public class ExchangeRatesDaoImpl implements ExchangeRatesDao {

	@Autowired
	ExchangeRatesRespository exchangeRatesRespository;
	
	Logger logger = LoggerFactory.getLogger(ExchangeRatesDaoImpl.class);
	
	@Override
	public void saveExchangeRatesToDb(ExchangeRatesEntity exchangeRatesEntity) {
		exchangeRatesRespository.save(exchangeRatesEntity);
	}

	@Override
	public ExchangeRatesEntity getAllExchangeRatesFromDb() {
		logger.info("getAllExchangeRatesFromDb called. fetching from repository.");
		List<ExchangeRatesEntity> exchangeRatesEntityList = exchangeRatesRespository.findAll();	
		if(exchangeRatesEntityList.size() >= 1) {
			return exchangeRatesEntityList.get(0);
		}
		return new ExchangeRatesEntity();			
	}	

}	
		