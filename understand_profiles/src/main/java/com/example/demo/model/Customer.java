package com.example.demo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Customer {

	private int customerId;
	private String customerName;
	private String email;
	
	
	@Autowired
	Environment env;
	
	@PostConstruct
	public void init() {
		
		log.info(env.getActiveProfiles().toString());
	}
	
	@PreDestroy
	public void destroy() {
		
		log.info("==========Destroy Method in Customer Called ========");
	}

	public Customer(int customerId, String customerName, String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
	}

}
