package com.caching.business;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caching.config.ExchangeUrlConfig;
import com.caching.dao.ExchangeRatesDao;
import com.caching.domain.ExchangeRates;
import com.caching.respository.ExchangeRatesRespository;
import com.caching.util.MapperUtil;

@Service
public class ExchangeServiceImpl implements ExchangeService {	
	
	@Autowired
	MapperUtil entityMapper;
	
	@Autowired
	ExchangeRatesDao exchangeRatesDao;	
	
	@Autowired
	ExchangeUrlConfig exchangeUrlConfig;
	
	@Autowired
	ExchangeRatesRespository exchangeRatesRespository;
	
	private String url;
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(ExchangeServiceImpl.class);
	
	@PostConstruct
	private void init() {
		url = exchangeUrlConfig.getExchangeApiUrl();
		restTemplate = new RestTemplate();
	}

	@Override
	public ExchangeRates requestLatestExchangeRatesFromApi() {
		logger.info("requestLatestExchangeRatesFromApi() received request.");
		return restTemplate.getForEntity(url, ExchangeRates.class).getBody();
	}

	@Override
	@Cacheable("exchangeRates")
	public ExchangeRates requestLatestExchangeRatesFromDb() {
		logger.info("requestLatestExchangeRatesFromDb() received request.");
		return entityMapper.mapEntityToPojo(exchangeRatesDao.getAllExchangeRatesFromDb());
	}
	
}	
