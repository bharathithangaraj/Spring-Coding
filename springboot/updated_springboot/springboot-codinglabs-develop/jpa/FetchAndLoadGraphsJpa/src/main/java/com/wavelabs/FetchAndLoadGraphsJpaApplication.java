package com.wavelabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavelabs.entities.User;
import com.wavelabs.repository.UserRepository;

@SpringBootApplication
public class FetchAndLoadGraphsJpaApplication  implements CommandLineRunner{
	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		User vijay = new User();
		vijay.setName("Vijay Pitala");
		vijay.addPhone("111-111-1111", "cell");
		vijay.addPhone("222-222-2222", "work");
		vijay.addAddress("111 Star Ave", "Sky Town", "Sunland");
		repository.save(vijay);
		
		User pitala = repository.findEntity("user-phones-entity-graph", "javax.persistence.fetchgraph");
		//User pitala = repository.findEntity("user-phones-entity-graph", "javax.persistence.fetchgraph");
		System.out.println("Persisted User: "+ vijay + "\n Found User: " + pitala);
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FetchAndLoadGraphsJpaApplication.class, args);
	}
}

