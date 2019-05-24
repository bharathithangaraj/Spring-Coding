/*package com.junit.testAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.junit.assertions.Employee;
import com.junit.repository.EmployeeRepository;

public class EmplyeeRepositoryTest {
    
	@PersistenceContext	
	EntityManager entityManager;
	
	@Autowired
	//EmployeeRepository employeeRepository;
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
	    
	    Employee alex = new Employee("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	    
	    //Employee found = employeeRepository.findByName(alex.getName());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(alex.getName());
	}
}*/