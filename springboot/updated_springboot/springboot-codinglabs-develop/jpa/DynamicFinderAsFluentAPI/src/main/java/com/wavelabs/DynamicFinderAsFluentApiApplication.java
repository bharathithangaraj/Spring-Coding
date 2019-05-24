package com.wavelabs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavelabs.jpaentities.Student;
import com.wavelabs.repository.StudentRepository;

@SpringBootApplication
public class DynamicFinderAsFluentApiApplication implements CommandLineRunner{
	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DynamicFinderAsFluentApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> list = repository.getNamesLike("Ra");
		System.out.println(list);
	}
}

