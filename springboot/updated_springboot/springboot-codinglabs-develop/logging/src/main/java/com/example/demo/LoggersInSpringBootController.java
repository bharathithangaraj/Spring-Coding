package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoggersInSpringBootController 
{
	Logger log = LoggerFactory.getLogger(LoggersInSpringBootController.class);
    
	@RequestMapping("/demo")
    public void demo()
    {
	 log.error("prints everytime except when OFF (or) FATAL levels are used");	
		
	 log.warn("prints when WARN (or) INFO (or) DEBUG (or) TRACE (or) ALL level is used");	
		
     log.info("prints when INFO (or) DEBUG (or) TRACE (or) ALL level is used ");
     
     log.debug("prints when DEBUG or TRACE or ALL level is used ");
     
     log.trace("prints when TRACE or ALL level is used");
     
    }
}
