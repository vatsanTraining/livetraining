package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;

@Configuration
public class ApplicationConfig {

	
	@Bean
	public Customer ramesh() {
		
		return new Customer(101,"Ramesh","ram@abc.com");
	}
	
}
