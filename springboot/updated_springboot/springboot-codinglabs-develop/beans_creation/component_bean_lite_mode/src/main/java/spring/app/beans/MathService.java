package spring.app.beans;

public class MathService {
  private Calculator calculator;

  public MathService(Calculator calculator) {
    this.calculator = calculator;
  }

  public Integer addNumbers(Integer... numbers) {
    return calculator.add(numbers);
  }

}
