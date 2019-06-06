package com.caching.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caching.respository.entity.ExchangeRatesEntity;

@Repository
public interface ExchangeRatesRespository extends JpaRepository<ExchangeRatesEntity, Long> {
}
	