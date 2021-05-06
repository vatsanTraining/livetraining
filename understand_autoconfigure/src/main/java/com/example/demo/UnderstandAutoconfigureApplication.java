package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.example.demo.conditions.CustomerCreationCondition;
import com.example.demo.model.Customer;

@SpringBootApplication
@ConfigurationProperties(prefix = "com.example")
public class UnderstandAutoconfigureApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext ctx	=SpringApplication.run(UnderstandAutoconfigureApplication.class, args);
	
	  System.out.println(ctx.getBean(Customer.class));
	
	}

	@Bean
	@Conditional(CustomerCreationCondition.class)
	public Customer suresh() {
		
		return new Customer(102,"Suresh","sur@abc.com");
	}

	@Bean

	@ConditionalOnExpression(value = 
	         "${server.port} =='6065'" )

	//@ConditionalOnProperty(name ="spring.application.name",havingValue = "auto")
	
	public Customer ramesh() {
		
		return new Customer(101,"Manish","mani@abc.com");
	}
	

}
