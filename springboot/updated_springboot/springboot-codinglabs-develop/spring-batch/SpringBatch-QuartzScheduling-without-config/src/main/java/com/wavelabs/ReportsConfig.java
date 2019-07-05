package com.wavelabs;

import org.springframework.batch.core.Job; 
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportsConfig {
//	@Autowired
//	private JobRegistry jobRegistry;
	public final static String jobName = "ReportsJob1";

	public JobBuilderFactory getJobBuilderFactory() {
		return jobBuilderFactory;
	}

	public void setJobBuilderFactory(JobBuilderFactory jobBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
	}

//	@Autowired
//	private Tasklet taskletstep;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public ReportTasklet reportTasklet() {
		return new ReportTasklet();
	}

	@Bean
	public Job job() throws DuplicateJobException {
		Job job = getJobBuilderFactory().get(jobName).start(getStep()).build();
		return job;
	}

	@Bean
	public Step getStep() {
		return stepBuilderFactory.get("step").tasklet(reportTasklet()).build();
	}
}