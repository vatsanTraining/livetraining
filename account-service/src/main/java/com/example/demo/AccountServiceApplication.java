package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Account;

@SpringBootApplication
@EnableEurekaClient
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	
	@Bean
	public Account account() {
		
		Account account = new Account();
		account.setAccountHolderName("Ramesh");
		account.setId(1010);
		account.setOutstanding(45000);

		return account;
	}
}
