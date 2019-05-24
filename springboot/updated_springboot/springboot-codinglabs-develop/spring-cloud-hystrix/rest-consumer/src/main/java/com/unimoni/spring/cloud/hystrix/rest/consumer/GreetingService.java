package com.unimoni.spring.cloud.hystrix.rest.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@DefaultProperties(
    groupKey = "Hystrix.greetingService",
    threadPoolKey = "thread-pool-greeting",
    threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "5")},
    commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),})
@Service
public class GreetingService {
  @HystrixCommand(fallbackMethod = "defaultGreeting")
  public String getGreeting(String username) {
    return new RestTemplate().getForObject("http://localhost:9090/greeting/{username}", String.class, username);
  }

  private String defaultGreeting(String username) {
    System.out.println("Using fallback");
    return "Hello Unimoni!";
  }
}
