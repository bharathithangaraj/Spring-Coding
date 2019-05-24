package com.example.demo.exceptions;

import java.util.Date;

public class ErrorDetails {

	private Date timeStamp;
	private String errorMessage;
	private String errorDescription;

	public ErrorDetails() {

	}

	public ErrorDetails(Date timeStamp, String errorMessage, String errorDescription) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
		this.errorDescription = errorDescription;

	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
