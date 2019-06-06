package com.caching.business;

import com.caching.domain.ExchangeRates;

public interface ExchangeService {
	ExchangeRates requestLatestExchangeRatesFromApi();
	ExchangeRates requestLatestExchangeRatesFromDb();
}
			