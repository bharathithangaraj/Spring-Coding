package com.wavelabs;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wavelabs.jpaentities.Student;
import com.wavelabs.repository.StudentRepository;

@SpringBootApplication
public class JpaCriteriaQueriesApplication  implements CommandLineRunner {
	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		int count=1;
		List<Student> list = repository.getStudentsByPassportNo("Singh", "A1234");
		//System.out.println(list);
		
		Iterator<Student> students = list.iterator();
		System.out.print("Using Jpa Criteria Query - Records Found are: \n");
		while (students.hasNext()) 
            System.out.print("\t"+count++ + ". "+students.next()+"\n"); 
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JpaCriteriaQueriesApplication.class, args);
	}

}

