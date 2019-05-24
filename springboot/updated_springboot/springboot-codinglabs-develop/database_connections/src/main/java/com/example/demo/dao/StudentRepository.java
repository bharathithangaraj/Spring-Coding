package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Student;


public interface StudentRepository  extends CrudRepository<Student,Integer> {

	
}
