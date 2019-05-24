package com.wavelabs.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.wavelabs.scheduling.AnotherBean;


public class ScheduledJob extends QuartzJobBean{

	
	private AnotherBean anotherBean; 
	
	
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		anotherBean.printAnotherMessage();
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}
}
