package com.junit.testParameterizedTestcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTestCase {
	@DisplayName("This will test the Parameterized testcase")
	@ParameterizedTest
	@ValueSource(ints = { 3, 6, 15})
	void divisibleByThree(int number) {
	    assertEquals(0, number % 3);
	}

}
