package com.retry.recovery.controller;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryRecoveryController {

	@RequestMapping("/")
	@Retryable(value = { NumberFormatException.class }, maxAttempts = 3)
	public String myApp() {
		System.out.println("API is calling");
		Integer.parseInt("");
		return "success";

	}

	@Recover
	public String RecoveryException(NumberFormatException ne) {

		System.out.println("Recover:::API is calling");

		return "Recover :: NumberFormatException ";

	}

}
