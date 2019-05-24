package com.uaex.config_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

	@Autowired
	private Configuration configratgion;
	
	@RequestMapping("/limits")
	public LimitConfiguration getLimitConfiguration() {
		return new LimitConfiguration(10, 1000);
	}
	
	
	@RequestMapping("/v2/limits")
	public LimitConfiguration getLimitConfigurationV2() {
		
		//return new LimitConfiguration(configratgion.getMin(), configratgion.getMax());
		return new LimitConfiguration(configratgion.getMin(), configratgion.getMax(), configratgion.getUsername(), configratgion.getPassword());
	}
	
	
}
