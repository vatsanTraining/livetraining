package com.example.demo.controllers;

import org.bouncycastle.asn1.ocsp.Request;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class ClientController {

	
	
	private WebClient client;

	@Autowired
	private ReactiveLoadBalancer<ServiceInstance> rlb;
	
	public ClientController(WebClient client) {
		super();
		this.client = client;
	}
	
	
	@GetMapping(path = "/client")
	public Flux<String> getAccountInfo() {
		
		Publisher<Response<ServiceInstance>> ob =rlb.choose();
		
		ob.subscribe(null);
		
		return client.get().uri("lb://RESTAURANT-INFO-SERVICE/api/v1/restaurants/")
				           .retrieve().bodyToFlux(String.class);
	}
	
}
