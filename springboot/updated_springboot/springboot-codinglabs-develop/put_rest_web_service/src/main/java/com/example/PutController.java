package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Employee;

@RestController
public class PutController
{
	 List<Employee> list = new ArrayList<Employee>();
	
	/**
	 * This method used to update the existing Employee Object 
	 * */

	@PutMapping("/updateEmployee")
	public List<Employee> updateEmployee(@RequestBody Employee employee)
	{
		 list.add(employee);
		 return list;
	}

}
