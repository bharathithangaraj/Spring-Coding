package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	
	@GetMapping("/addStudent")
	public Student addStudent(Student student) {
		return repo.save(student);
		
		
	}
	
	
	@PostMapping("student")
	public Student createStudentDeatails(@RequestBody Student student) {
		
		return repo.save(student);
	}
	

	@PutMapping("/Student")
	public  Student SaveorUpdateStudent(@RequestBody Student student) {
		
	return  repo.save(student);
		
	}
	
	@DeleteMapping("/deletestudent")
	public Student Delete(@RequestBody Student student) {
		
		repo.deleteById(4443);
		return student;
		
	}

}
