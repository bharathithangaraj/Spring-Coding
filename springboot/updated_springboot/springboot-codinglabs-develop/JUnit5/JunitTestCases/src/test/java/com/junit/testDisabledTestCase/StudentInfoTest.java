package com.junit.testDisabledTestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit.nestedTestCase.StudentInfo;

class StudentInfoTest {
	private StudentInfo std;
	@DisplayName("This method will not be tested..it's disabled!!")
    @Disabled
	@Test
	void whenAssertingSameInfo_thenSuccessful()
    	{
    	std=new StudentInfo(1,"Alex");
    	
    		assertSame("ALex",std.getStudentName());
    		System.out.println("This method will not be tested..it's disabled!!");
	}

}
