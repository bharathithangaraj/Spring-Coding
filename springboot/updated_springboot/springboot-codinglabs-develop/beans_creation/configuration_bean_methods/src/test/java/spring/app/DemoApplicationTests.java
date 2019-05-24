package spring.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.app.beans.Calculator;
import spring.app.beans.MathService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

  @Autowired
  MathService mathService;

  @Test
  public void addNumbers() {
    Integer[] numbers = {1, 2, 3, 4, 5};
    Integer sumOfNumbers = mathService.addNumbers(numbers);
    logger.info("Sum Of Numbers: {}", sumOfNumbers);
  }


}
