package com.junit.testAssertions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.function.BooleanSupplier;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
@DisplayName("Test Different Assertion Test Cases")
public class TestAssertions {

	@DisplayName("Test AssertEquals method")
	@Test
	public void whenAssertingEquality_thenEqual() {
		    String expected = "success";
		    String actual =   "success";
		 
		    assertEquals(expected, actual);
	}
	@DisplayName("Test AssertArrayEquals Method")
	@Test
		public void whenAssertingArraysEquality_thenEqual() {
		char[] expected = { 'J', 'u', 'p', 'i', 't', 'e', 'r' };
		char[] actual = "Jupiter".toCharArray();
	    assertArrayEquals(expected, actual, "Arrays should be equal");
	}

	@DisplayName("Test AssertTrue method")
	@Test
	public void whenAssertingConditions_thenVerified() {
		assertTrue(5 > 4, "5 is greater the 4");
		assertTrue(null == null, "null is equal to null");
		}
	
	@DisplayName("Test AssertFlase method")
	@Test
		public void givenBooleanSupplier_whenAssertingCondition_thenVerified() {
		BooleanSupplier condition = () -> 5 > 6;
		assertFalse(condition, "5 is not greater then 6");
		
	}
	
	}


