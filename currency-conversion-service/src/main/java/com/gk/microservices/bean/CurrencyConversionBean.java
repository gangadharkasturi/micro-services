package com.gk.microservices.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private int id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private BigDecimal conversionMultiple;
	private int port;

	public CurrencyConversionBean(int id, String from, String to, BigDecimal quantity, BigDecimal totalCalculatedAmount,
			BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}

	public CurrencyConversionBean() {
		super();

	}

	public int getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	

}
