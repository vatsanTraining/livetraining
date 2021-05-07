package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.RestaurantDTO;

import reactor.core.publisher.Flux;

@RestController
public class ClientController {

	
	private WebClient client;

	public ClientController(WebClient client) {
		super();
		this.client = client;
	}
	
	@GetMapping(path = "/api/v1/client")
	public Flux<RestaurantDTO> getAll(){
		
		    return this.client.get()
		    		.uri("http://localhost:7075/api/v1/restaurants")
		    		.retrieve()
		    		.bodyToFlux(RestaurantDTO.class);
		    
	}
}
