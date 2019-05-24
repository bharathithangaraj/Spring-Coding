package com.example.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// @EnableEurekaClient  // optional if you are using spring-cloud-starter-netflix-eureka-client
public class SpringEurekaClientStudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientStudentServiceApplication.class, args);
	}
}
