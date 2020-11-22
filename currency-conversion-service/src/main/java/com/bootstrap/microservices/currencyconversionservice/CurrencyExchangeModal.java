package com.bootstrap.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CurrencyExchangeModal {

	
	private String currencyFrom;
	
	private String currencyTo;
	
	private BigDecimal multiplier;
	
	private BigDecimal quantity;
	
	private BigDecimal calculatedAmount;
	
	private Integer port;

	
	/**
	 * 
	 */
	public CurrencyExchangeModal() {
		super();
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
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
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

	/**
	 * @return the calculatedAmount
	 */
	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	/**
	 * @param calculatedAmount the calculatedAmount to set
	 */
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	
	
}
