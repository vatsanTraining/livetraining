package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Invoice {

	private int invoiceNumber;
	private Customer customer;
	private Product product;
	
	
	public Invoice(@Qualifier("ramesh") Customer customer, @Qualifier("tv") Product product) {
		super();
		this.customer = customer;
		this.product = product;
	}

	
	
}
