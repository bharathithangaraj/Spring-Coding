package com.wavelabs.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wavelabs.jpaentities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select st from Student as st where st.id=:id")
	Student findStudentForWrite(@Param("id") Long id);

	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select st from Student as st where st.id=:id")
	Student findStudentForRead(@Param("id") Long id);
	
}