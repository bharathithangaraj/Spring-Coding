package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Employee;

@RestController
public class PostController
{
	 List<Employee> list = new ArrayList<Employee>();
	 
	/**
	 * This method used to create one Employee Object
	 * */

	@PostMapping("/createEmployee")
	public List<Employee> createEmolyee(@RequestBody Employee employee)
	{
		list.add(employee);
		
		return list;
	}

}
