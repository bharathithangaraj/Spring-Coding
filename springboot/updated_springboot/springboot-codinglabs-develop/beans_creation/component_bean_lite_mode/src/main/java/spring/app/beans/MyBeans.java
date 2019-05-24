package spring.app.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBeans {
  @Bean
  public Calculator getCalculator() {
    return new Calculator();
  }

  @Bean
  public MathService getMathService() {
    return new MathService(getCalculator());
  }
}
