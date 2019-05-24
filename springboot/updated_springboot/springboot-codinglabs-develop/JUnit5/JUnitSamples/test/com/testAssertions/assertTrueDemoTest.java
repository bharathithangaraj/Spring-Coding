package com.testAssertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.assertions.assertTrueDemo;

class assertTrueDemoTest {

	@Test
	public void compareStringtest() {
		assertTrueDemo demo=new assertTrueDemo();
		assertTrue(demo.compareString("hello", "hello"));
	}
}
