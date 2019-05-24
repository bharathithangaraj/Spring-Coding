package com.wavelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wavelabs.jpaentities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>, StudentRepositoryCustom{
	
}