package com.wavelabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavelabs.repository.StudentRepository;

@SpringBootApplication
public class SpringJpqlFinderQueryApplication implements CommandLineRunner{
	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpqlFinderQueryApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repository.deleteById(10002L);
	}

}

