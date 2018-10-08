package com.gk.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.microservices.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	@Autowired
	private LimitsConfiguration configuration;

	@GetMapping(value = "/limits")
	public LimitsConfiguration retrieveLimitsConfiguration() {
		return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
}
