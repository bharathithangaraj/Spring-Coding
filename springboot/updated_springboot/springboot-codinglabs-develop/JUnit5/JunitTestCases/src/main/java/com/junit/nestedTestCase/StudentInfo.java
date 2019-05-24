package com.junit.nestedTestCase;

import org.springframework.stereotype.Repository;

@Repository
public class StudentInfo extends Student {

	public StudentInfo(int studentId, String studentName) {
		super(studentId, studentName);
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) {
		StudentInfo info=new StudentInfo(101, "smith");
		System.out.println(info.getStudentName());
	}

}
