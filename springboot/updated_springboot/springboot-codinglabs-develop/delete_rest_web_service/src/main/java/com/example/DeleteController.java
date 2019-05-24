package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pojo.Employee;

public class DeleteController 
{
	List<Employee> list = new ArrayList<Employee>();

	/**
	 * This method used to delete one Employee Object
	 * */

	@DeleteMapping("/deleteEmployee")
	public Boolean deleteEmployee(@RequestBody Employee employee)
	{
		boolean status = list.remove(employee);
		return status;
	}
}
