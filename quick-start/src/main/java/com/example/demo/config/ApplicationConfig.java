package com.example.demo.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

@Configuration
public class ApplicationConfig {

	
	@Bean
	public Customer ramesh() {
		
		return new Customer(101,"Ramesh","ram@abc.com");
	}
	
	@Bean
	public Product tv() {
		
		return new Product(101,"sony tv");
	}
}
