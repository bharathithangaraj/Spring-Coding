package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamsExample
{

	/**
	 * This method used to get the user entered value through URI and returns the value
	 * */

	@RequestMapping("/{id}")
	public String usingPathVariable(@PathVariable int id)
	{
		return "Path variable is : "+id;

	}

	/**
	 * This method used to get the user entered value from web page and returns the value
	 * */

	@RequestMapping("/print")
	public String usingRequestParam(@RequestParam int id)
	{
		return "Request param value is : "+id;		
	}

	/**
	 * This method used to get the user entered value from web page and returns the value
	 * */

	@RequestMapping("/")
	public Integer returnIntegerData(@RequestParam(defaultValue = "10",required = true) int id)
	{
		return id;
	}

}
