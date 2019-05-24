package jpa.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
@Configuration
@EnableTransactionManagement
public class ExampleMain {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ExampleMain.class, args);
    ExampleClient exampleClient = context.getBean(ExampleClient.class);
    try {
      exampleClient.saveEmployees();
    } catch (Exception e) {
      System.err.println(e);
    }
    exampleClient.findEmployees();

    exampleClient.debit();
    exampleClient.credit();
  }

}
