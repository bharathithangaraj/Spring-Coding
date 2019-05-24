package com.junit.assertions;

public class EmployeeRepository {
	public Employee findByName(String name) {
		Employee emp1 = new Employee(name);
		return emp1;
	}
}
