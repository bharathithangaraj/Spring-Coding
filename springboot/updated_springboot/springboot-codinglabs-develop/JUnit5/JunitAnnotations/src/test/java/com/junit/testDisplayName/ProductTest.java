package com.junit.testDisplayName;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit.displayName.Product;
@DisplayName("This method is going to test the Product class")
class ProductTest {
 private Product product;
	@Test
	@DisplayName("")
	void test() {
		product=new Product();
		
		fail("Not yet implemented");
	}

}
