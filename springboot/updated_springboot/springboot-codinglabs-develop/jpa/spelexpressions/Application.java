package com.wavelabs.spelexpressions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		SpelExpWithDefaultValue appName = new SpelExpWithDefaultValue();
		System.out.println("Default Value given by Spel Expression is: "+appName.getDefaultAppName());
		
		UserRegionAndLocaleImpl userLocale = new UserRegionAndLocaleImpl();
		System.out.println("User Default Locale: "+userLocale.getDefaultLocale());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
