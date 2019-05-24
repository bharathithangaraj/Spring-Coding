package com.example.demo;

import org.omg.IOP.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;




/*
 to configure classes 
 */

@Configuration

public class App {
	

	/*
 a bean to be managed by the Spring container
	 */
	
	@Bean

	public String SayHi() {
		return "hi";

	}

}
