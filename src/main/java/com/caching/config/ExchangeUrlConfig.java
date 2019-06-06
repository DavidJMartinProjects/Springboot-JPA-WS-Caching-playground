package com.caching.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("urls.currency")
public class ExchangeUrlConfig {
	
	String exchangeApiUrl;

	public String getExchangeApiUrl() {
		return exchangeApiUrl;
	}

	public void setExchangeApiUrl(String exchangeApiUrl) {
		this.exchangeApiUrl = exchangeApiUrl;
	}

}
