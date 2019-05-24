package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
 @Component indicates that a class might be a candidate for creating a bean 
 */

@Component

public class Bean {

	/*
 @Autowired annotation can be applied on variables and methods for autowiring byType
	 */

	@Autowired
	private String Hello() {
		return "haii";

	}
}
