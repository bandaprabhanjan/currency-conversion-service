
package com.example.currency.convert.exception;

import java.util.Date;

public class ExceptionBean {
	private Date timestamp;
	private String message;
	private String descrpition;

	public ExceptionBean(Date timestamp, String message, String descrpition) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.descrpition = descrpition;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescrpition() {
		return descrpition;
	}
}
