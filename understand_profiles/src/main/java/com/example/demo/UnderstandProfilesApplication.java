package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import com.example.demo.model.Customer;

@SpringBootApplication
public class UnderstandProfilesApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=SpringApplication.run(UnderstandProfilesApplication.class, args);
	
	
          Customer cust = ctx.getBean(Customer.class);
          
          System.out.println("Is Singleton :="+ ctx.isSingleton("suresh"));
          System.out.println("Is Prototype :="+ ctx.isPrototype("suresh"));
           
	
	  ctx.close();
	}

	@Bean
	@Profile(value = "dev")
	//@Lazy
	public Customer suresh() {
		
		return new Customer(102,"Developer Suresh","sur@abc.com");
	}

	@Bean
	@Profile(value = "prod")
	//@Lazy
	public Customer ramesh() {
		
		return new Customer(101,"Admin Manish","mani@abc.com");
	}
	

}
