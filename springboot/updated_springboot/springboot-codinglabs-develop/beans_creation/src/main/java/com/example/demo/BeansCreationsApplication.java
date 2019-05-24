package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

/*
 @ComponentScan is searching packages for Components.
 */

@ComponentScan

public class BeansCreationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeansCreationsApplication.class, args);
	}
}
