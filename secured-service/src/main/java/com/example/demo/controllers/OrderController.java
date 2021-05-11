package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;

@RestController
public class OrderController {

	
	@Autowired
	@Qualifier("firstOrder")
	private Order firstOrder;
	
	@Autowired
	@Qualifier("secondOrder")
	private Order secondOrder;
	
	
	
	@GetMapping(path = "/orders")
	public Order getOrder() {
		
		return firstOrder;
	}
	
	@GetMapping(path = "/orders/{id}")
	public Order getOrderById(@PathVariable("id") int id) {
		
		return secondOrder;
	}
	
}
