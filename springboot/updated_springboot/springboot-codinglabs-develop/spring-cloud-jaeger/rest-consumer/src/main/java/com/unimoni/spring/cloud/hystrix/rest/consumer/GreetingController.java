package com.unimoni.spring.cloud.hystrix.rest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
  @Autowired
  private GreetingService greetingService;

  @RequestMapping("/get-greeting/{username}")
  public String getGreeting(@PathVariable("username") String username) {
    return greetingService.getGreeting(username);
  }
}
