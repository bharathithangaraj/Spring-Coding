package spring.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.app.beans.Calculator;
import spring.app.beans.MathService;

@Configuration
public class MyBean {

  @Bean
  public Calculator getCalculator() {
    System.out.println("getCalculator is executing ");
    return new Calculator();
  }

  @Bean
  public MathService getMathService() {
    return new MathService(getCalculator());
  }
}
