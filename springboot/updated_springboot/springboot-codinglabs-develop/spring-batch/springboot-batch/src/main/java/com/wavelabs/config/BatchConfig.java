package com.wavelabs.config;

import org.springframework.batch.core.Job; 
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wavelabs.listener.JobCompletionListener;
import com.wavelabs.step.Processor;
import com.wavelabs.step.Reader;
import com.wavelabs.step.Writer;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		System.out.println("IN JOB");
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}
	@Bean
	public Step orderStep1() {
		System.out.println("IN STEP");
		return stepBuilderFactory.get("orderStep1").<String, String> chunk(2)
				.reader(new Reader()).processor(new Processor())
				.writer(new Writer()).build();
	}
	@Bean
	public JobExecutionListener listener() {
		System.out.println("IN LISTENER");
		return new JobCompletionListener();
	}

}
