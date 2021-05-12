package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
import java.util.*;
@Component
public class CustomAuthenticationGlobalFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		
		  	  
		//boolean isPresent =  exchange.getRequest().getURI().getPath().contains("api");
		
		boolean isPresent =  exchange.getRequest().getURI().getPath().contains("pkl");
		
		if(isPresent) {
			
			 exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			 return exchange.getResponse().setComplete();
		}
		
		return chain.filter(exchange);
	}

}
