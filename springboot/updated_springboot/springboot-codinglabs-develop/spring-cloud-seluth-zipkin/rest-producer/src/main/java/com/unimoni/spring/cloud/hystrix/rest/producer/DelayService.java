package com.unimoni.spring.cloud.hystrix.rest.producer;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DelayService {
  Random random = new Random();

  public void simulateDelay() {
    int waitTime = Math.abs(random.nextInt(3000));
    try {
      System.out.println("Waitig for millis:" + waitTime);
      Thread.sleep(waitTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (Exception e) {
    }
  }
}
