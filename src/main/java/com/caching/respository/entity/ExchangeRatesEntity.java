package com.caching.respository.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonInclude(Include.NON_NULL)
@Table(name="exchange_rates")
@JsonPropertyOrder({"date", "base", "rates"})
public class ExchangeRatesEntity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
	@Column(name="date")
	private String date;
		
	@ElementCollection	
	private Map<String, String> rates;
	
	@Column(name="base")
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
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	
	@Override
	public String toString() {
		return "ExchangeRatesEntity [id=" + id + ", date=" + date + ", rates=" + rates + ", base=" + base + "]";
	}	

}
	