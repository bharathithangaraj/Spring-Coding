package com.wavelabs.programatic.flow;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableBatchProcessing
@ImportResource("classpath:batchjob.xml")
public class SpringBatchProgrammaticFlowDecisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProgrammaticFlowDecisionApplication.class, args);
	}
}
