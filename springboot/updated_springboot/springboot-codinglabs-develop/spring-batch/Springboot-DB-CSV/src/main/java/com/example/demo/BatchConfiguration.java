package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Users1;

//batchDatabaseInitializer
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;
	
	private Resource outputResource = new FileSystemResource("Users.csv");

	@Bean
	public JdbcCursorItemReader<Users1> reader() {
		JdbcCursorItemReader<Users1> reader = new JdbcCursorItemReader<Users1>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT id,name FROM user");
		reader.setRowMapper(new UserRowMapper());

		return reader;
	}

	public class UserRowMapper implements RowMapper<Users1> {

		@Override
		public Users1 mapRow(ResultSet rs, int rowNum) throws SQLException {
			Users1 user = new Users1();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));

			return user;
		}

	}

	@Bean
	public UserItemProcessor processor() {
		return new UserItemProcessor();
	}

	@Bean
	public FlatFileItemWriter<Users1> writer() {
		FlatFileItemWriter<Users1> writer = new FlatFileItemWriter<Users1>();
		writer.setResource(outputResource);
		writer.setLineAggregator(new DelimitedLineAggregator<Users1>() {
			{
				setDelimiter(",");
				setFieldExtractor(new BeanWrapperFieldExtractor<Users1>() {
					{
						setNames(new String[] { "id", "name" });
					}
				});
			}
		});

		return writer;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Users1, Users1>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	@Bean
	public Job exportUserJob() {
		return jobBuilderFactory.get("exportUserJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}
}