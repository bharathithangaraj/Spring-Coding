package com.sunitkatkar.blogspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunitkatkar.blogspot.model.Employee;
import java.lang.String;
import java.util.List;

/**
 * JPA Entity Repository which provides access to all database operations for
 * the 'employee' table
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstName(String firstname);
}
