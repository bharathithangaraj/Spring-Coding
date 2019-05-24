package com.unimoni.spring.cloud.hystrix.rest.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerImpl implements GreetingController {

  @Autowired
  DelayService delayService;

  @Override
  public String greeting(@PathVariable("username") String username) {
    delayService.simulateDelay();
    return String.format("Hello %s!\n", username);
  }
}
