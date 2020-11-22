/**
 * 
 */
package com.bootstrap.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mshaikh4
 *
 */
@FeignClient("currency-exchange-service")
/* (name = "currecy-exchange-service", url = "localhost:") */
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currencyexchange/from/{currencyFrom}/to/{currencyTo}")
	public CurrencyExchangeModal getExchangeValue(@PathVariable String currencyFrom, @PathVariable String currencyTo);

}
