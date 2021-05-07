package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Review;
import com.example.demo.repos.ReviewRepository;

@SpringBootApplication
public class ReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {

		return new CommandLineRunner() {
			
			@Autowired
			ReviewRepository repo;
			@Override
			public void run(String... args) throws Exception {

				repo.save(new Review(202, "Sagar", "manish", "food", "excellent", 4.6));
				repo.save(new Review(203, "Swagath", "ashish", "ambience", "good", 4.2));
				
				
				
			}
		};
		
	}
}
