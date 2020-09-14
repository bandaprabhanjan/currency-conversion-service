
package com.example.currency.convert;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConvertMultipleExcception extends RuntimeException {

	public ConvertMultipleExcception(String message) {
		super(message);
	}

}
