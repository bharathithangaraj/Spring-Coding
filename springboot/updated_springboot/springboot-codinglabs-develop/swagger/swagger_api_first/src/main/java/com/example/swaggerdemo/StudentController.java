package com.example.swaggerdemo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	List<Student> students = new ArrayList<Student>();
	
	@PostConstruct
	public void createDetails() {
		
			students.add(new Student("radha", "IV", "XYZ"));
	}
	@GetMapping(value = "/all")
	public List<Student> getStudents() {
		return students;
	}
	@PostMapping(value="/")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}
	@GetMapping(value = "/{name}")
	public Student getStudent(@PathVariable(value = "name") String name) {
     
		for(Student std: students) {
			if(std.getName()==name) {
				return std;
			}
		}
		return null;
	}
}
