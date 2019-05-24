package com.junit.testNestedTestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import com.junit.nestedTestCase.StudentInfo;

class StudentInfoTest {
private StudentInfo std;
    @DisplayName("This will test the Nested testcases")
	@Test
	void whenAssertingSameInfo_thenSuccessful()
	{
	std=new StudentInfo(1,"smith");
	
		assertSame("smith",std.getStudentName());
	}  
 @Nested
 class Student {
	 
	 @Test
	 void InnerClass_Test() {
		 System.out.println("inner class test");
		 
	 }
	 
 }
 }
	