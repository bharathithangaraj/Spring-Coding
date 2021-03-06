package com.wavelabs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wavelabs.jpaentities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	List<Student> fetchByNameLength(@Param("length") Long length);
}
