package spring.app.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Calculator {
  Logger logger = LoggerFactory.getLogger(Calculator.class);
  static int instanceCnt = 0;

  public Calculator() {
    instanceCnt++;
    logger.info("Calculator instance count: {}", instanceCnt);
  }

  public Integer add(Integer... operands) {
    return Arrays.stream(operands).mapToInt(i -> i.intValue()).sum();
  }
}
