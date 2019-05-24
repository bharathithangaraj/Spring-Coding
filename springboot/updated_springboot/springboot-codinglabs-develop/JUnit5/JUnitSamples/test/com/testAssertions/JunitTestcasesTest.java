package com.testAssertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.assertions.JunitTestcases;

class JunitTestcasesTest {


	@Test
	public void concat() {
		JunitTestcases junit =new JunitTestcases();
		String result=junit.Concat("Wave", "Labs");
		assertEquals("WaveLabs",result);
		
	}

	@Test
	public void Add() {
		JunitTestcases junit =new JunitTestcases();
		int result=junit.add(10, 20);
		assertEquals(30,result);
}
}
