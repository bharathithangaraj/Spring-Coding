package com.external;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.app.beans.Calculator;

@Configuration
public class MyBeanExternal {
  @Bean("calc")
  public Calculator mathCalculator() {
    return new Calculator();
  }

  @Bean
  public String copyrightMessage() {
    return "sdfsdfd sfdsf dsf sdf";
  }
}
