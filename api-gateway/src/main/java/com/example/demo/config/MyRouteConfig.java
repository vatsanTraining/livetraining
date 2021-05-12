package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteConfig {

	
	  @Bean
	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
	    
	         return builder.routes()
	           .route(p -> p.path("/api/v1/restaurants/**")
	           .uri("lb://RESTAURANT-INFO-SERVICE") )
	                .route(p -> p.path("/accounts/**")
	                .uri("lb://ACCOUNT-SERVICE"))
	                .build();
	}

}
