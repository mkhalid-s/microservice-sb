package com.bootstrap.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.cloud.client.loadbalancer.reactive.WebClientCustomizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients 
/* (basePackages = "com.bootstrap.microservices.currencyconversionservice") */
public class CurrencyConversionServiceApplication {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	
	
	@GetMapping("/currencyconversion/from/{currencyFrom}/to/{currencyTo}/{quantity}")
	/* @LoadBalanced */
	public CurrencyExchangeModal getCurrecyConversionFromQuantity(@PathVariable String currencyFrom, @PathVariable String currencyTo, @PathVariable BigDecimal quantity) {
		
		CurrencyExchangeModal rs = currencyExchangeProxy.getExchangeValue(currencyFrom, currencyTo);
		
		rs.setQuantity(quantity);
		rs.setCalculatedAmount(quantity.multiply(rs.getMultiplier()));
		
		return rs;
		
	}
	
	
	@LoadBalanced
	@GetMapping("/currencyconversion-lb/from/{currencyFrom}/to/{currencyTo}/{quantity}")
	public CurrencyExchangeModal getCurrecyConversionFromQuantityLb(@PathVariable String currencyFrom, @PathVariable String currencyTo, @PathVariable BigDecimal quantity) {
		CurrencyExchangeModal rs = currencyExchangeProxy.getExchangeValue(currencyFrom, currencyTo);
		
		rs.setQuantity(quantity);
		rs.setCalculatedAmount(quantity.multiply(rs.getMultiplier()));
		
		return rs;
		
	}
	
	

}
