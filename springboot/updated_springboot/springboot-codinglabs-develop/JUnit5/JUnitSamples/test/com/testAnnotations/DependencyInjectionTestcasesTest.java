package com.testAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.annotations.DependencyInjectionTestcases;

class DependencyInjectionTestcasesTest {

	@DisplayName("TestInfo Demo")
	class TestInfoDemo {

	    TestInfoDemo(DependencyInjectionTestcases testInfo) {
	        assertEquals("TestInfo Demo", testInfo.getDisplayName());
	    }

	    @BeforeEach
	    public void init(DependencyInjectionTestcases testInfo) {
	        String displayName = testInfo.getDisplayName();
	        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
	    }

	    @Test
	    @DisplayName("TEST 1")
	    public void test1(DependencyInjectionTestcases testInfo) {
	        assertEquals("TEST 1", testInfo.getDisplayName());
	       
	}
	    @Test
	   public void test2() {
	    }

	}
	}



