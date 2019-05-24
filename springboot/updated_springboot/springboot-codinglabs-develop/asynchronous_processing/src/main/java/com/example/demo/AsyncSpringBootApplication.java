package com.example.demo;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class AsyncSpringBootApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(AsyncSpringBootApplication.class, args);
	}
	
	
	 @Bean(name = "asyncExecutor")
	    public Executor asyncExecutor()
	    {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(3);
	        executor.setMaxPoolSize(3);
	        executor.setQueueCapacity(100);
	        executor.initialize();
	        return executor;
	    }
}
