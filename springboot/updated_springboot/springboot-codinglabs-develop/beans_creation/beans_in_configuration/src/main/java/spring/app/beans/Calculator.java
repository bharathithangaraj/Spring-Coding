package spring.app.beans;


import java.util.Arrays;
import java.util.function.Function;

public class Calculator {
  public Calculator(){
    System.out.println(" in constructor");
  }
  public Integer add(Integer... operands){
    return Arrays.stream(operands).mapToInt(i -> i.intValue()).sum();
  }

  public Integer add123(Function abc,Integer... operands){
    return Arrays.stream(operands).mapToInt(i -> i.intValue()).sum();
  }
}
