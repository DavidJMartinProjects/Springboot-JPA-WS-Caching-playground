package com.caching.domain;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ExchangeRates {
	
	private String date;
	private Map<String, String> rates;
	private String base;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getBase() {
		return base;
	}

	@Override
	public String toString() {
		return "ExchangeRates [date=" + date + ", rates=" + rates + ", base=" + base + "]";
	}

}