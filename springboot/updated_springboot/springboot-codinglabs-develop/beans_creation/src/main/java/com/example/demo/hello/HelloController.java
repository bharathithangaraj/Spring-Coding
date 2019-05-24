package com.example.demo.hello;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

/*
 this annotation can be applied only classes

 */
@Service

public class HelloController {

	/*

 specific request path or pattern onto a controller.

	 */

	@RequestMapping(value="/hello")

	public String SayHi() {
		return "hi";
	}



}
