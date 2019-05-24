package com.wavelabs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	private String firstName;
	private String lastName;
	private String designation;
	private String salary;
	private ContactDetails contactDetails;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, String designation, String salary,
			ContactDetails contactDetails) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
		this.contactDetails = contactDetails;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", designation="
				+ designation + ", salary=" + salary + ", contactDetails=" + contactDetails + "]";
	}
	
}
