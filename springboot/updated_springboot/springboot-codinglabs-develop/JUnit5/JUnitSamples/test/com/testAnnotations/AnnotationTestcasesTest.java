package com.testAnnotations;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.annotations.AnnotationTestcases;

class AnnotationTestcasesTest {
	static AnnotationTestcases test=null;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	test=new AnnotationTestcases();
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	test=null;
}
	@Test
	public void test1() {
		System.out.println("First");
	}
	@Test
	public void test2() {
		System.out.println("Second");
	}

}
