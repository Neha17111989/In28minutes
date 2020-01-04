package com.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExcahngeController {
	
	@Autowired
	Environment env;
	
	@Autowired
	CurrencyRepo repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExcangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		//ExcangeValue obj=new ExcangeValue(1000, from, to, 65);
		ExcangeValue obj=repo.findByFromAndTo(from, to);
		obj.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return obj;
	}

}
