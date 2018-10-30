package com.gk.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gk.microservices.bean.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service",url="http://localhost:8000")
//@FeignClient(name="currency-exchange-service")//removed URL because the url will be handled by ribbon, i.e. load balancing
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping(value="/currency-exchange-service/currency-exchange-service/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") final String from,@PathVariable("to") final String to);
	

}
