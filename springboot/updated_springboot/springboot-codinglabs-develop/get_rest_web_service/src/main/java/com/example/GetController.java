package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Employee;

@RestController
public class GetController 
{

	 List<Employee> list = new ArrayList<Employee>();
	 
	/**
	 * This method used to get all the employee objects from server
	 * */
    
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees()
	{
		return list;
	}
	
}
