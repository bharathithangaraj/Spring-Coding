package com.example.demo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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



	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		repo.save(student);
		return "home.jsp";

	}


	@RequestMapping(value="/getStudent",produces=MediaType.APPLICATION_JSON_VALUE)

	public Student  getStudent(@RequestParam("id") int id) {




		Student student=repo.findById(id).orElse(new Student());

		System.out.println(student);

		System.out.println(repo.findByLang("hibernate"));

		System.out.println(repo.findByidGreaterThan(100));

		return student;


	}


	@PutMapping("/Student")
	public Student SaveorUpdateStudent(@RequestBody Student student) {

		repo.save(student);
		return student;

	}

	@DeleteMapping("/Student")
	public Student Delete(@RequestBody Student student) {

		repo.deleteById(500);
		return student;

	}

}
