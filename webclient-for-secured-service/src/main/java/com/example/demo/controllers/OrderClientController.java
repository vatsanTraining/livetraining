package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
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
		
		return client.get().uri("http://localhost:6565/orders")
				.headers(header -> header.setBasicAuth("india","india"))
				 .retrieve().onStatus(HttpStatus::is5xxServerError, 
						  clientResponse ->
			        Mono.error(new RuntimeException()))
			        .bodyToMono(String.class);

		
	}
}
