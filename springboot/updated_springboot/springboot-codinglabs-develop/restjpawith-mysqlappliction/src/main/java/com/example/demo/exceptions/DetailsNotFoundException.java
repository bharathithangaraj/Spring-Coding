package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DetailsNotFoundException extends RuntimeException {

	public DetailsNotFoundException(String message) {
		super(message);
	}

	public DetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
