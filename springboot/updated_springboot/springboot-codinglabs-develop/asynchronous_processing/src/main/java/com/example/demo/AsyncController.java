package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController 
{
	@Autowired
	AsyncService service;
	
	@RequestMapping("/testasync")
    public String testAsync()  throws InterruptedException, ExecutionException
    {
		System.out.println("Started");
		
		service.async1();
		service.async2();
		service.async3();
	
		System.out.println("Stop");
		
		
		return "successful";
    	
    }
}
