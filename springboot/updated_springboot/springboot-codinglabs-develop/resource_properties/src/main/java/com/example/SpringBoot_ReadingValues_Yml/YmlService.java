package com.example.SpringBoot_ReadingValues_Yml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YmlService {
	
	/*
	 * Here we are using @value annotation for every field
	 * to fetch the data from the property files 
	 * 
	 * */

	@Value("${company.siteUrl}")
	private String url;
	@Value("${company.type}")
	private String type;
	@Value("${Employee.role}")
	private String role;
	@Value("${Employee.tech}")
	private String tech;
	
	/*
	 * The value in the Request mapping annotation is an endpoint of the url 
	 * to that particular method to run in server or postman
	 * 
	 * */
	public static String method() {
        String name="darshan janney";
		return name;
	}
	@RequestMapping(value = "/fetch")
	public List<String> printProperties() {
		
    //To print the values on console		
	System.out.println("company url : "+ url);
	System.out.println("company type : "+ type);
	System.out.println("Employee role : "+ role);
	System.out.println("Employee tech : "+ tech);
	
	//To print the values on postman or server
	List<String> list=new ArrayList<>();
	list.add(role);
	list.add(tech);
	list.add(type);
	list.add(url);
	
	return list;
	}
}
