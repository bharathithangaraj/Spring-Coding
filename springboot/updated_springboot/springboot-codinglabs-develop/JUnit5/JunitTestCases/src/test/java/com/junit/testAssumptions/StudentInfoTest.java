package com.junit.testAssumptions;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.Test;
import com.junit.assumptions.StudentInfo;


public class StudentInfoTest {
	
	private StudentInfo info;
	
    @Test
	public void getStudentInfo() {
    	info = new StudentInfo();
		info.setPassportNumber("P345J34");
		info.setName("John");
		
        assumeTrue("John".equals(info.getName()));
        
        assumeTrue("P345J34".equals(info.getPassportNumber()));
	}
}





