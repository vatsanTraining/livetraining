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
public class LoadBalancedClientController {

	private WebClient client;

	public LoadBalancedClientController(WebClient client) {
		super();
		this.client = client;
	}
	
	@GetMapping(path = "/api/v2/client")
	public Flux<RestaurantDTO> getAll(){
		
		    return this.client.get()
		    		.uri("lb://RESTAURANT-INFO-SERVICE/api/v1/restaurants")
		    		.retrieve()
		    		.bodyToFlux(RestaurantDTO.class);
		    
	}
	
	@PostMapping(path = "/api/v2/client")
	public Mono<RestaurantDTO> add(@RequestBody RestaurantDTO dto){
		
		return this.client.post()
				.uri("lb://RESTAURANT-INFO-SERVICE/api/v1/restaurants")
				 .body(Mono.just(dto),RestaurantDTO.class).retrieve().bodyToMono(RestaurantDTO.class);
		
	}

}
