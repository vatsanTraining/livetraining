package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.RestaurantDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
	
	@PostMapping(path = "/api/v1/client")
	public Mono<RestaurantDTO> add(@RequestBody RestaurantDTO dto){
		
		return this.client.post()
				.uri("http://localhost:7075/api/v1/restaurants")
				 .body(dto,RestaurantDTO.class).retrieve().bodyToMono(RestaurantDTO.class);
		
	}
}
