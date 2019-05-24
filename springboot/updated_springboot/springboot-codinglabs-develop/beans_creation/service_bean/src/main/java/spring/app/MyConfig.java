package spring.app;

import org.springframework.context.annotation.Configuration;
import spring.app.service.Calculator;

@Configuration
public class MyConfig {

  private Calculator calculator;

  public MyConfig(Calculator calculator){
    this.calculator = calculator;
  }

  public void add(Integer...a){
    calculator.add(a);
  }

}
