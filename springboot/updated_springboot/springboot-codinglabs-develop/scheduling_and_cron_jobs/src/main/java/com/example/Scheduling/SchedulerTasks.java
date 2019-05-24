package com.example.Scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerTasks {
	
  public static final SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
  
  /*
   * fixedRate: executes the method with a fixed period of milliseconds between invocations.
   * initialDelay: in starting delays the invocation of method for given milliseconds
   * 
   * */
//  @Scheduled(fixedRate=5000, initialDelay=15000)
//  public void performFixedTask() {
//	  
//	  System.out.println("Fixedrate method invoking with intial delay" + dateformat.format(new Date()));
//  }
  
  /* 
   * fixedDelay:  executes the method with a fixed period of milliseconds between the end of one invocation
   *  and the start of the next.
   * 
   * */
  
//  @Scheduled(fixedDelay=5000, initialDelay=10000)
//  public void performDelayTask() {
//	  
//	  System.out.println("fixedDelay task invoking after intial delay " + dateformat.format(new Date()));
//  }
  
  
  /*
   * cron:  uses cron-like expressions to determine when to execute the method
   * 
   * Here this method invocates after every 5 Seconds of the day
   * 
   * */
  @Scheduled(cron="0 30 16 2/1 * *")
  public void performCronJob() {
	  
	  System.out.println("Cron job is invoking with by given expression(Every 1 min a day) "+ dateformat.format(new Date()));
  }
}
