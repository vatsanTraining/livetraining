package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Customer;

@SpringBootApplication
public class OauthGithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthGithubApplication.class, args);
	}

	@Bean
	public Customer ramesh() {
		
		return new Customer(110,"Ramesh Patil",4505050);
	}

}
