package com.wavelabs.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.wavelabs.jpaentities.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		StoredProcedureQuery getByProcedure =
				entityManager.createNamedStoredProcedureQuery("getAllStudents");
	    return getByProcedure.getResultList();
	}

}
