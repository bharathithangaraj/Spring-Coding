package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController  //used to denote class as a Restcontroller for RestAPI Operations
public class WelcomeRestController
{
	/**
	 * This method simply returns the message what we are return
	 * */

	@RequestMapping("/message")
	public String printMessage(String message)
	{
		message = "Welcome to Spring boot";
		return message;
	}
}
