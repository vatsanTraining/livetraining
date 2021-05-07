package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepository;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerRepository repo;
	
	
	@GetMapping(path = "/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) {
		
		return this.repo.findById(id).get();
		
	}
}
