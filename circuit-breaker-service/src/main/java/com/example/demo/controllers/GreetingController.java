package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class GreetingController {

	
	
	@Autowired
	RestTemplate template;
	
	
	@GetMapping(path = "/books")
	@CircuitBreaker(name = "bookClient",fallbackMethod = "fallBack")
	public String showGreeting() {
		
		return template.getForObject("http://localhost:8081/books", String.class);
	}
	
	
	public String fallBack(Exception e) {
		
		System.out.println(e.getMessage());
		return "Service Not Working -Try again";
	}
	
}
