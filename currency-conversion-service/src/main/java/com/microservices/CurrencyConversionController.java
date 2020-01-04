package com.microservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCourrency(@PathVariable String from, @PathVariable String to,
			@PathVariable int quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().
				getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		return new CurrencyConversionBean(response.getId(), 
				from, to, quantity, response.getConversionMultiple(),
				quantity*response.getConversionMultiple(), response.getPort());
	}
}
