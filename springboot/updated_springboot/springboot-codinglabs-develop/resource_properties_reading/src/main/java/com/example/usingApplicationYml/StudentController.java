package com.example.usingApplicationYml;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentDao;

	/* 
	 * This method is used to create student details 
	 * on postman and 
	 * used to add them in to the database
	 * 
	 * */
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentDao.saveStudent(student);
	}

	/*
	 * This method is used to get all student details for database
	 * 
	 * */
	
	@GetMapping("/student")
	public List<Student> getAllEmployees(){
		return studentDao.findAllStudents();
	}

	/*
	 * This method is used to get the particular student by the given {id}
	 * Using @pathvariable from the database
	 * 
	 * */
	
	@GetMapping("/student/{id}")
	public Student getEmployeeById(@PathVariable(value="id") int id){

		Student student=studentDao.findOneStudent(id);
		
		return student;
	}


	/*
	 * This method is used to update the student details 
	 * of particular student by given id and updating in to the database
	 * 
	 * */
	
	@PutMapping("/student/{id}")
	public Student updateEmployee(@PathVariable(value="id") int id, @RequestBody Student studentDetails){

		Student student=studentDao.findOneStudent(id);

		student.setName(studentDetails.getName());
		student.setTechnology(studentDetails.getTechnology());
       
		Student updateStudent=studentDao.saveStudent(student);
		return updateStudent;
	}

	/*
	 * This method is used to delete the student 
	 * of the particular student given by {id}
	 * from the database
	 * 
	 * */
	
	@DeleteMapping("/student/{id}")
	public Student deleteStudent(@PathVariable(value="id") int id){

		Student student=studentDao.findOneStudent(id);

		studentDao.deleteOneStudent(student);

		return student;
	}
}
