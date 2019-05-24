package spring.app.service;


import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Calculator {
  public Integer add(Integer... operands) {
    return Arrays.stream(operands).mapToInt(i -> i.intValue()).sum();
  }
}
