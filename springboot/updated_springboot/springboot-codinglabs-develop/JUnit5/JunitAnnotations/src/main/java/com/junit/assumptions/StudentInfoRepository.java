package com.junit.assumptions;

import com.junit.assertions.Employee;

public class StudentInfoRepository {

public StudentInfo findByName(String name) {
	StudentInfo student1 = new StudentInfo(name, name);
	return student1;
}

public void getStudentInfo(StudentInfo s1) {
	// TODO Auto-generated method stub
	
}
}
