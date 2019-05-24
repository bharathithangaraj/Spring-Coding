package com.unimoni.exception;
/**
 * 
 * @author gopi
 *
 */
public class AadharNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AadharNotFoundException() {

	}

	AadharNotFoundException(String message) {
		super(message);
	}

}
