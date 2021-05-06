package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Customer;

@SpringBootApplication
public class QuickStartApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx	=SpringApplication.run(QuickStartApplication.class, args);
	
	
	  Customer ram = ctx.getBean(Customer.class);
	  
	  System.out.println(ram);
	
	}

}
