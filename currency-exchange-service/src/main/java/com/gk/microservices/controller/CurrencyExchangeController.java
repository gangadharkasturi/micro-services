package com.gk.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gk.microservices.bean.ExchangeValue;
import com.gk.microservices.dao.ExchangeServiceRepository;

/**
 * http://localhost:8000/currency-exchange-service/from/USD/to/INR
 * 
 * @author GANGADHAR
 *
 */
@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExchangeServiceRepository exchangeServiceRepository;
	
	@GetMapping(value="/currency-exchange-service/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable final String from,@PathVariable final String to)
	{

		ExchangeValue exchangeValue =  exchangeServiceRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}",exchangeValue);
		return exchangeValue;
	}
}
