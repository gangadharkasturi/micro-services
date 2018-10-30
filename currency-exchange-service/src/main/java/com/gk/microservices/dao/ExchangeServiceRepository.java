package com.gk.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.microservices.bean.ExchangeValue;

public interface ExchangeServiceRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
