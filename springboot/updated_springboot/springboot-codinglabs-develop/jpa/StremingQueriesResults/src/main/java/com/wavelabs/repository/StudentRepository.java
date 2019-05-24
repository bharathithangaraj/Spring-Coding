package com.wavelabs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import javax.persistence.QueryHint;
import com.wavelabs.jpaentities.Student;

@Repository
@Transactional(readOnly = true)
public interface StudentRepository extends JpaRepository<Student,Long>{
	@QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE, value = "" + Integer.MIN_VALUE))
	@Query("select st from Student as st where st.name like %?1")
    List<Student> findByNameEndsWith(String chars);
}