package com.satish.monitoring.health;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id="mypoint")
@Component
public class MyPointEndPoint {
    @ReadOperation
    public String mypoint(){
        return "Hello" ;
    }
}
