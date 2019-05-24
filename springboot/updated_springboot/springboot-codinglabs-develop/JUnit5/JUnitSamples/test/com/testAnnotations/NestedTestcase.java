package com.testAnnotations;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestedTestcase {
	@Test
	 void test() {
	 System.out.println("Outer Class Test");
}
	        @Nested
	        class InnerClass {
	        @Test
	        void test() {
	        System.out.println("Inner Class Test");
	       }
	  }
	}


