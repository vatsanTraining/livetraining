package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Order;

@SpringBootApplication
public class SecuredServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredServiceApplication.class, args);
	}

	
	@Bean
	public Order firstOrder() {
		
		return new Order(101,"pending",LocalDateTime.now());
	}
	
	
	@Bean
	public Order secondOrder() {
		
		return new Order(102,"completed",LocalDateTime.now());
	}
}
