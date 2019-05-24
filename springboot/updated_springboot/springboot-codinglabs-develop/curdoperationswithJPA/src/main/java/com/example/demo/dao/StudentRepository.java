package com.example.demo.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.Student;


public interface StudentRepository  extends CrudRepository<Student,Integer> {

	
	List<Student> findByLang(String Lang);
	
	List<Student> findByidGreaterThan(int i);


}
