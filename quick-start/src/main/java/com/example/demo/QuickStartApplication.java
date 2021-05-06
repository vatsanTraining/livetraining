package com.example.demo;

import org.module.orders.OrderBook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.Product;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","org.module.orders"})
public class QuickStartApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx	=SpringApplication.run(QuickStartApplication.class, args);
	
	
	System.out.println(ctx.getClass().getName());
	
	  Customer ram = ctx.getBean("ramesh",Customer.class);
	  
	  System.out.println(ram);
	
	  
//	  Invoice invoice1 = ctx.getBean(Invoice.class);
//	  
//	  System.out.println(invoice1);
//	  
	  
Invoice invoice1 = ctx.getBean("invoice",Invoice.class);
	  
	  System.out.println(invoice1);
	  
	  
      Invoice invoice2 = ctx.getBean("invoice2",Invoice.class);
	  
	  System.out.println(invoice2);
	  
	  System.out.println(ctx.getBean(OrderBook.class));
	  
	}

	@Bean
	public Customer suresh() {
		
		return new Customer(102,"Suresh","sur@abc.com");
	}
	
	@Bean
	public Product laptop() {
		
		return new Product(102,"dell inspirion");
	}
	@Bean
	public Invoice invoice2() {
		
		return new Invoice(suresh(), laptop());
	}
}
