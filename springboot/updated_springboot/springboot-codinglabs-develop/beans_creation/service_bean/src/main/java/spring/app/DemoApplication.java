package spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

  private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
  private static ApplicationContext applicationContext;

  public static void main(String[] args) {
    applicationContext = SpringApplication.run(DemoApplication.class, args);
  }

}
