package com.example.currency.convert;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

public class CurrencyConvertBean {
	@Size(min = 2)
	private Long id;
	private String from;
	private String to;
	private BigDecimal convertMultiple;
	private BigDecimal quantity;
	private BigDecimal totalamount;
	private int port;

	public BigDecimal getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(BigDecimal totalamount) {
		this.totalamount = totalamount;
	}

	public CurrencyConvertBean() {
		super();
	}

	public CurrencyConvertBean(Long id, String from, String to, BigDecimal convertMultiple, BigDecimal quantity,
			BigDecimal totalamount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertMultiple = convertMultiple;
		this.quantity = quantity;
		this.totalamount = totalamount;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getconvertMultiple() {
		return convertMultiple;
	}

	public void setconvertMultiple(BigDecimal convertMultiple) {
		this.convertMultiple = convertMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
