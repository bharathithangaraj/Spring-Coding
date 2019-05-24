package com.wavelabs.tasklets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;


@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchJobConfig {
  @Autowired
  JobBuilderFactory jobFactory;
  @Autowired
  StepBuilderFactory stepFactory;
  @Bean
  public Job firstJob() {
    return jobFactory.get("FirstJob")
        .start(simpleTask())
//        .next(simpleTask())
        .incrementer(new RunIdIncrementer())
        .build();
  }
  @Bean
  public TaskletStep simpleTask() {
    return stepFactory.get("say-hello").tasklet(new Tasklet() {
      Logger logger = LoggerFactory.getLogger("Simple-Task");

      @Override
      public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        logger.info("Hi!.... Spring Batching Expert!");
//        return RepeatStatus.FINISHED;
        // return status control the repeatable nature of tasklet
        return null;
      }
    }).build();
  }

  @Autowired
  JobLauncher jobLauncher;
  @Scheduled(cron = "*/5 * * * * *")
  // more info on Cron expression https://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm
  public void settlementProcessor() throws Exception {

    System.out.println("Job Started at :" + new Date());

    JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
        .toJobParameters();

    JobExecution execution = jobLauncher.run(firstJob(), param);

    System.out.println("Job finished with status :" + execution.getStatus());
  }

}
