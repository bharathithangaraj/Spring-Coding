package com.junit.assertions;

public class Employee {
	
	private String name;
		
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	public Employee() {
		super();
	} 
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}

