package com.testAssertions;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertEquals {


	@Test
	public void whenAssertingEquality_thenEqual() {
		    String expected = "success";
		    String actual =   "success";
		 
		    assertEquals(expected, actual);
		}
	}


