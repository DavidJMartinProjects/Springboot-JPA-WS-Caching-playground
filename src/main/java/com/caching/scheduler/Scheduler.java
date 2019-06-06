package com.caching.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.caching.business.ExchangeService;
import com.caching.dao.ExchangeRatesDao;
import com.caching.domain.ExchangeRates;
import com.caching.respository.entity.ExchangeRatesEntity;
import com.caching.util.MapperUtil;

@Configuration
@EnableScheduling
public class Scheduler {
	
	@Autowired 
	MapperUtil entityMapper;
	
	@Autowired
	ExchangeService exchangeService;
	
	@Autowired
	ExchangeRatesDao exchangeRatesDao;
	
	private Logger logger = LoggerFactory.getLogger(Scheduler.class);
	
	@Scheduled(initialDelay = 10000, fixedRate = 20000)
	public void pollAndPersistExchangeRates() {
		logger.info("Scheduled task pollAndPersistExchangeRates() called."); 
		ExchangeRates exchangeRates = exchangeService.requestLatestExchangeRatesFromApi();		
		ExchangeRatesEntity exchangeRatesEntity = entityMapper.mapPojoToEntity(exchangeRates);
		exchangeRatesDao.saveExchangeRatesToDb(exchangeRatesEntity);
		logger.info("Scheduled task pollAndPersistExchangeRates() complete."); 
	}
	
}		
		