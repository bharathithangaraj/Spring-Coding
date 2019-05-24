/*package com.wavelabs.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.wavelabs.jpaentities.Student;

@Repository
@Transactional(readOnly = true)
public class CustomStudentRepositoryImpl implements CustomStudentRepository{

    @PersistenceContext
    EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getNamesLike(String name){
		Query query = entityManager.createNativeQuery(
	        	"SELECT st.* FROM wavelabs.student as st WHERE st.name LIKE ?", Student.class);
		query.setParameter(1, name+"%");
		List<Student> stList = query.getResultList();
		return stList;
	}
}*/
