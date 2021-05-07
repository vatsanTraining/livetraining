package com.example.demo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Reservation;
import com.example.demo.repo.ReservationRepository;

@SpringBootApplication
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			ReservationRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				
				Customer rahul = new Customer(120,"Shiv",4528484);
				Customer vikas = new Customer(127,"Mangal",9848732);
				
				List<Customer> custList = Arrays.asList(rahul,vikas);
				
				Reservation resDay1 = new Reservation(1012L,"Sagar",LocalDateTime.now(), custList);
				
				repo.save(resDay1);
				
				
			}
		};
	}
}
