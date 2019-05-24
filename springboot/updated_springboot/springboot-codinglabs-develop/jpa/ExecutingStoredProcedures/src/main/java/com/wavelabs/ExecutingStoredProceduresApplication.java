package com.wavelabs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavelabs.jpaentities.Student;
import com.wavelabs.repository.StudentRepository;

@SpringBootApplication
public class ExecutingStoredProceduresApplication implements CommandLineRunner{
	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		List<Student> list = repository.getAllStudents();
		System.out.println(list);
	}
	public static void main(String[] args) {
		SpringApplication.run(ExecutingStoredProceduresApplication.class, args);
	}
}

