package com.wavelabs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavelabs.jpaentities.Student;
import com.wavelabs.repository.StudentRepository;
import com.wavelabs.services.UserTransaction;

@SpringBootApplication
public class PessimisticLockingJpaApplication implements CommandLineRunner{
	@Autowired
	StudentRepository repository;
	
	@Autowired
	UserTransaction userTransaction;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Student aditya = new Student(4l,"Aditya","346227"); repository.save(aditya);
		 */
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(userTransaction::runUser1Transaction);
		es.execute(userTransaction::runUser2Transaction);
		es.shutdown();
		es.awaitTermination(5, TimeUnit.MINUTES);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PessimisticLockingJpaApplication.class, args);
	}

}

