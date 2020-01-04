package com.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepo extends JpaRepository<ExcangeValue, Integer> {

	ExcangeValue findByFromAndTo(String from, String to);
	
}
