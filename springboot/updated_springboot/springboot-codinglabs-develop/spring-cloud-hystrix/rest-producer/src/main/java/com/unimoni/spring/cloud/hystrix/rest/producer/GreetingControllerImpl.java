package com.unimoni.spring.cloud.hystrix.rest.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GreetingControllerImpl implements GreetingController {
    Random random = new Random();

    @Override
    public String greeting(@PathVariable("username") String username) {
        int waitTime = Math.abs(random.nextInt(1000));
        try {
            System.out.println("Waitig for millis:" + waitTime);
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("Hello %s!\n", username);
    }
}
