package com.gk.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
/**
 * 
 * @author Gangadhar
 * // http://localhost:8765/currency-exchange-service/currency-exchange-service/from/USD/to/INR
 * url of zuul/application-name/uri of api
 *
 */
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
