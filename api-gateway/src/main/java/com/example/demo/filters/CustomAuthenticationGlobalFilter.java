package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

import java.util.*;
@Component
public class CustomAuthenticationGlobalFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		
		 List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
		 

        org.springframework.http.server.reactive.ServerHttpRequest modifiedRequest = exchange.getRequest().mutate().
                header("Authorization", authorization.get(0)).build();
				 
        return chain.filter(exchange.mutate().request(modifiedRequest).build());

		
	}

}



