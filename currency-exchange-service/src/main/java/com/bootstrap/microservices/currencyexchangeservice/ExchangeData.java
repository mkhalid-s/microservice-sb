package com.bootstrap.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExchangeData {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String currencyFrom;
	
	private String currencyTo;
	
	private BigDecimal multiplier;
	
	private Integer port;
	
	public ExchangeData() {
		super();
	}

	/**
	 * @param currencyFrom
	 * @param currencyTo
	 * @param multiplier
	 * @param port
	 */
	public ExchangeData(String currencyFrom, String currencyTo, BigDecimal multiplier, Integer port) {
		super();
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.multiplier = multiplier;
		this.port = port;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the currencyFrom
	 */
	public String getCurrencyFrom() {
		return currencyFrom;
	}

	/**
	 * @param currencyFrom the currencyFrom to set
	 */
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	/**
	 * @return the currencyTo
	 */
	public String getCurrencyTo() {
		return currencyTo;
	}

	/**
	 * @param currencyTo the currencyTo to set
	 */
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	/**
	 * @return the multiplier
	 */
	public BigDecimal getMultiplier() {
		return multiplier;
	}

	/**
	 * @param multiplier the multiplier to set
	 */
	public void setMultiplier(BigDecimal multiplier) {
		this.multiplier = multiplier;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
	
	
}
