package com.junit.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.junit.assertions.Employee;
import com.junit.assertions.EmployeeRepository;

@SpringBootApplication
public class JunitAnnotationsApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository empRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JunitAnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		empRepo.findByName("pinky");
	}

}

