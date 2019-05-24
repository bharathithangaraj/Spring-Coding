package com.wavelabs.repository;

import java.util.List;
import com.wavelabs.jpaentities.Student;

public interface IStudentRepositoryCustom {
	List<Student> getStudentsByPassportNo(String name, String passportNumber);
}
