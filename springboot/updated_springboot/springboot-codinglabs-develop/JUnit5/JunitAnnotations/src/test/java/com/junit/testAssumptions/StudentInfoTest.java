package com.junit.testAssumptions;

//import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

//import org.assertj.core.api.Assumptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.junit.assumptions.StudentInfo;


public class StudentInfoTest {

	private StudentInfo info;
    @Test
	public void getStudentInfo() {
		//info.setPassportNumber("P345J34");
        assumeTrue("jhon".equals(info.getStudentInfo()));
        /*StudentInfo s1 = info.setPassportNumber(new StudentInfo("5"));
    	
    	assumeTrue(s1.getPassportNumber(), "5");*/
		
	}
}





