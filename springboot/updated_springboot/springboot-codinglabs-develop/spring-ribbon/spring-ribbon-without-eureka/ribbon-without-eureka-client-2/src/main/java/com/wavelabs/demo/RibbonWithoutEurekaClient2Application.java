package com.wavelabs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "server", configuration = RibbonConfiguration.class)
public class RibbonWithoutEurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(RibbonWithoutEurekaClient2Application.class, args);
	}

}

