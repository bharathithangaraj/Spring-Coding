package spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.app.beans.Calculator;

@SpringBootApplication(scanBasePackages = { "spring.app" , "com.external"})
public class DemoApplication {

  private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
  private static ApplicationContext applicationContext;

  public static void main(String[] args) {
    System.out.println("before " );
    applicationContext = SpringApplication.run(DemoApplication.class, args);
    System.out.println("after run" );

    System.out.println("before getbean" );
    int total = (( Calculator)applicationContext.getBean("calc")).add(1,20);
    System.out.println("total " + total);

    total = (( Calculator)applicationContext.getBean(Calculator.class)).add(1,200);
    System.out.println("total " + total);

    System.out.println(applicationContext.getBean("copyrightMessage"));

  }
}
