package com.unimoni;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.unimoni.exception.RestTemplateResponseErrorHandler;

@SpringBootApplication
public class AadherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AadherServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}

	@Bean(name = "template2")
	public RestTemplate restTemplate2(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofSeconds(3)).setReadTimeout(Duration.ofSeconds(4)).build();
	}

}
