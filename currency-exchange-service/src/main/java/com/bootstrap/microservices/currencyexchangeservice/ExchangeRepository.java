/**
 * 
 */
package com.bootstrap.microservices.currencyexchangeservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mshaikh4
 *
 */
@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeData, Integer> {
	
	ExchangeData findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);

}
