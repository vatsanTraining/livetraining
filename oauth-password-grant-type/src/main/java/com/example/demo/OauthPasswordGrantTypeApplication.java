package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.example.demo.domain.Customer;

@SpringBootApplication
@EnableResourceServer
public class OauthPasswordGrantTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthPasswordGrantTypeApplication.class, args);
	}

	@Bean
	public Customer ramesh() {
		
		return new Customer(110,"Ramesh Patil",4505050);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
}
