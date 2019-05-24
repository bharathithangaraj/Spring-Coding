package com.junit.testParameterizedTestcase;

import static org.junit.Assert.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
	 
	import static org.junit.jupiter.api.Assertions.assertNotNull;
	 
	@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
	class ValueSourceTest {
	 
	    @DisplayName("Should pass a non-null message to our test method")
	    @ParameterizedTest(name = "{index} => message=''{0}''")
	    @ValueSource(strings = {"Hello", "Wavelabs"})
	    void shouldPassNonNullMessageAsMethodParameter(String message) {
	        assertNotNull(message);
	    }
	}
	
	 


