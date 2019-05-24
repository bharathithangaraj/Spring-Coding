package com.example.demo;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService 
{
	
   @Async
   public void async1() throws InterruptedException
   {
	   System.out.println("Started async1");
	   
	   Thread.sleep(1000L);
	   
	   System.out.println("Stoped async1");
	   
	
   }
   
   @Async
   public void async2() throws InterruptedException
   {
	   System.out.println("Started async2");
	 
	   Thread.sleep(1000L);
	   
	   System.out.println("Stoped async2");
	   
	
	   
   }
   
   @Async
   public void async3() throws InterruptedException
   {
	   System.out.println("Started async3");
	   
	   Thread.sleep(1000L);
	   
	   System.out.println("Stoped async3");
	
   }
   
}
