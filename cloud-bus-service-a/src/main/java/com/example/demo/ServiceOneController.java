package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServiceOneController {

	
	@Value("${custom.message}")
	private String message;
	
	
	@GetMapping(path = "/info")
	public String getMessage() {
		
		return this.message;
		
	}
}
