package com.example.demo.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.di.model.Engine;
import com.example.demo.di.model.Transmission;
@Configuration
public class AppConfig {
	
	@Bean
	public Engine engine() {
		
		 return new Engine("v8");
	}

	@Bean
	public Transmission transmission() {
		return new Transmission("sliding");
	}
}