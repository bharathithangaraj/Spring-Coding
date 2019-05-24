package springbatch.flowjob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class JobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public JobRepository jobRepository() {
		try {
			return new MapJobRepositoryFactoryBean(transactionManager())
					.getJobRepository();
		} catch (Exception e) {
			return null;
		}
	}

	@Bean
	public JobLauncher jobLauncher() {
		final SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository());
		return launcher;
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").
				flow(stepA()).on("*").stop().from(stepA()).on("*").to(stepB()).next(stepC()).end().build();
				}

	/*
	 * @Bean public Job job() { return jobBuilderFactory.get("job").
	 * flow(stepA()).on("FAILED").to(stepC()).
	 * from(stepA()).on("*").to(stepB()).next(stepC()).end().build(); }
	 */
	@Bean
	public Step stepA() {
		return stepBuilderFactory.get("stepA")
				.tasklet(new RandomFailTasket("stepA")).build();
	}

	@Bean
	public Step stepB() {
		return stepBuilderFactory.get("stepB")
				.tasklet(new PrintTextTasklet("stepB")).build();
	}

	@Bean
	public Step stepC() {
		return stepBuilderFactory.get("stepC")
				.tasklet(new PrintTextTasklet("stepC")).build();
	}
}
