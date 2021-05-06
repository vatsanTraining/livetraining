package com.example.demo.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
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
	
	
	@Bean
	public Customer suresh() {
		
		return new Customer(102,"Suresh","sur@abc.com");
	}
	
	@Bean
	public Product laptop() {
		
		return new Product(102,"dell inspirion");
	}
	
	
	@Bean
	public Invoice invoice2() {
		
		return new Invoice(suresh(), laptop());
	}
}
