package com.gk.microservices;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gk.microservices.bean.CurrencyConversionBean;

/**
 * 
 * @author Gangadhar
 * http://localhost:8100/currency-conversion-service/from/USD/to/INR/quantity/10
 * http://localhost:8765/currency-exchange-service/currency-exchange-service/from/USD/to/INR
 *
 */
@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	

	@GetMapping(value = "/currency-conversion-service/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable final String from, @PathVariable final String to,
			@PathVariable final BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange-service/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		
		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

	}
	
	@GetMapping(value = "/currency-conversion-service-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable final String from, @PathVariable final String to,
			@PathVariable final BigDecimal quantity) {
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

	}
	}



