package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class OrderClientController {

	
	private WebClient client;

	public OrderClientController(WebClient client) {
		super();
		this.client = client;
	}
	
	
	@GetMapping(path = "/client/orders")
	public Mono<String> getOrder() {
		
		
		
	}
}
