package com.wavelabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavelabs.entities.Country;
import com.wavelabs.entities.Currency;
import com.wavelabs.repositories.CountryRepository;
import com.wavelabs.repositories.CurrencyRepository;

@SpringBootApplication
public class JMockitoWithDbProjectApplication implements CommandLineRunner{

	@Autowired 
	CountryRepository countryRepository;
	
	@Autowired 
	CurrencyRepository curRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JMockitoWithDbProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Country usa = countryRepository.save(new Country("USA","New York"));
		System.out.println(usa);
		
		Currency usd = new Currency("USD", 1, usa);
		usd = curRepository.save(usd);
		System.out.println(usd);
		*/
		System.out.println("Started..");
	}

}

