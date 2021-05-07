package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.Info;
import com.example.demo.model.RestaurantDTO;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class InfoController {

	

	
	private WebClient client;

	public InfoController(WebClient client) {
		super();
		this.client = client;
	}
	
	
	@GetMapping(path = "/client/{name}")
	public Mono<Info> getInfo(@PathVariable("name") String name){
		
		   Mono<RestaurantDTO> restaurants = getDetails(name).subscribeOn(Schedulers.boundedElastic());

		    Mono<ReviewsDTO> reviews = getReviews(name).subscribeOn(Schedulers.boundedElastic());

		    return Mono.zip( reviews,restaurants, Info::new);

			}
	
	
		public Mono<RestaurantDTO> getDetails(String name){
		
		    return this.client.get()
		    		.uri("http://localhost:7075/api/v1/restaurants/srch/"+name)
		    		.retrieve()
		    		.bodyToMono(RestaurantDTO.class);
		    
	}
	
	
		public Mono<ReviewsDTO> getReviews(String name){
			
		    return this.client.get()
		    		.uri("http://localhost:7070/reviews/search/names/?srchName="+name)
		    		.retrieve()
		    		.bodyToMono(ReviewsDTO.class);
		    
	}

}
