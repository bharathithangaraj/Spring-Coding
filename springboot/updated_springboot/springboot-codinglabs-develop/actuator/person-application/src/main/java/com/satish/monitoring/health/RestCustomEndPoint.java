package com.satish.monitoring.health;

import org.apache.tomcat.util.net.AbstractEndpoint; 
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RestControllerEndpoint(id = "rest-end-point")
public class RestCustomEndPoint {

    @GetMapping("/custom")
    public @ResponseBody
    ResponseEntity customEndPoint(){
        return  new ResponseEntity<>("REST end point", HttpStatus.OK);
    }
}
