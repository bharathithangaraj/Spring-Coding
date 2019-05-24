package com.wavelabs.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.wavelabs.jpaentities.Student;

@Repository
@Transactional(readOnly = true)
public class StudentRepositoryImpl implements IStudentRepositoryCustom{
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public List<Student> getStudentsByPassportNo(String name, String passportNumber) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
	 
	    Root<Student> student = cq.from(Student.class);
	    List<Predicate> predicates = new ArrayList<>();
	    if (passportNumber != null) {
	        predicates.add(cb.like(student.get("name"), "%" + name + "%"));
	    }
	    if (passportNumber != null) {
	        predicates.add(cb.like(student.get("passportNumber"), "%" + passportNumber + "%"));
	    }
	    cq.where(predicates.toArray(new Predicate[0]));
	 
	    return entityManager.createQuery(cq).getResultList();
	}

}
