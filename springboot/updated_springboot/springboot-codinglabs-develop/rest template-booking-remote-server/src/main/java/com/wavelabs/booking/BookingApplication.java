package com.wavelabs.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.wavelabs.booking")
public class BookingApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	
}
