package com.bootstrap.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {
	
	@Autowired
	org.springframework.core.env.Environment env;
	
	@Autowired
	private ExchangeRepository exchangeRepository;
	
	private boolean isSqlInserted = false;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	private void insertDataintoH2() {
		
		ExchangeData e = new ExchangeData("USD", "INR", BigDecimal.valueOf(75), 0);
		exchangeRepository.save(e);
		e = new ExchangeData("EUR", "INR", BigDecimal.valueOf(88), 0);
		exchangeRepository.save(e);
		e = new ExchangeData("DHR", "INR", BigDecimal.valueOf(17), 0);
		exchangeRepository.save(e);
	}

	@GetMapping("/currencyexchange/from/{currencyFrom}/to/{currencyTo}")
	public ExchangeData getExchangeValue(@PathVariable String currencyFrom, @PathVariable String currencyTo) {
		if (currencyFrom != null && currencyTo != null) {
			
			if (!isSqlInserted) {
				insertDataintoH2();
				isSqlInserted = true;
			}
			
			ExchangeData rtn = exchangeRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
			if (rtn != null) {
				rtn.setPort(Integer.valueOf(env.getProperty("server.port")));
			}
			return rtn;
		}
		return null;
	}

}
