package com.sunitkatkar.blogspot.service;

import java.util.List;

import com.sunitkatkar.blogspot.model.Employee;

public interface EmployeeService {

	void save(Employee emp);

	List<Employee> findByFirstName(String firstName);

	List<Employee> findAll();

}
