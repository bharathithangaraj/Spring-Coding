package com.testAnnotations;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import com.annotations.RepeatedTestAnnotation;


class RepeatedTestCase {

	@RepeatedTest(2)
	void repeatedTest(RepeatedTestAnnotation repeatedtest) {
	System.out.println("Executing repeated test");
	}
	
	@BeforeEach
	void beforeEachTest() {
	    System.out.println("Before Each Test");
	}

	@AfterEach
	void afterEachTest() {
	    System.out.println("After Each Test");
	    System.out.println("=====================");
	}

}
