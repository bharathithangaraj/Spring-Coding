package com.example.usingApplicationYml;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@Service
@ComponentScan("com.example")
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	/*
	 * This method is used to persist the student details
	 * into the datbase
	 *  
	 *  */
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	/* 
	 * 
	 * This method is used to get all the stduent from database
	 * 
	 * */
	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}
	
	/*
	 * This method is used to get the particular student
	 * 
	 * */
	public Student findOneStudent(int id) {
		return studentRepository.getOne(id);
	}
	
	/*
	 * This method is used to delete the student from the database
	 * 
	 * */
	public void deleteOneStudent(Student student) {
		studentRepository.delete(student);
	}
	
}
