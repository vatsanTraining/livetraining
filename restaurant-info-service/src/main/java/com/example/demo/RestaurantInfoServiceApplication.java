package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repos.RestaurantInfoRepository;
import com.example.demo.entity.*;
@SpringBootApplication
public class RestaurantInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantInfoServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			RestaurantInfoRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new RestaurantInfo(101, "Gokul Tiffins", "chennai", "gokul@abc.com", "veg", "6.00 am to 10.00 P.m"));
				
				
			}
		};
	}
}
