package com.wavelabs.repository;

import java.util.List;

import com.wavelabs.jpaentities.Student;

public interface CustomStudentRepository {
	List<Student> getNamesLike(String name);
}
