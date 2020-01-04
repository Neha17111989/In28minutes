package com.microservices.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
	
	@Autowired
	Configuration customConfiguration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		
		return new LimitConfiguration(customConfiguration.getMaximum(),customConfiguration.getMinimum());
	}

	
}
