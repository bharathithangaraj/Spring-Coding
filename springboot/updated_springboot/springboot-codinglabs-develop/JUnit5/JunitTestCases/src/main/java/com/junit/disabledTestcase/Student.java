package com.junit.disabledTestcase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.junit.nestedTestCase.StudentInfo;

@Entity
public class Student {
@Id
@GeneratedValue
private int studentId;
private String studentName;
/**
 * @param studentId
 * @param studentName
 */
public Student(int studentId, String studentName) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
}
public Student(StudentInfo studentInfo) {
	// TODO Auto-generated constructor stub
}
public int getStudentId() {
	return studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}


}
