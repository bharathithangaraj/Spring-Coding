package com.junit.testRepeatedTestCase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("This will test the Repeated Testcases")
class RepeatedTestCase {
	@RepeatedTest(2)
	void repeatedTest() {
	System.out.println("Executing repeated test");
	}
	
	@BeforeEach
	void beforeEachTest() {
	    System.out.println("Before Each Test");
	}

	@AfterEach
	void afterEachTest() {
	    System.out.println("After Each Test");
	   
	}
	
}
