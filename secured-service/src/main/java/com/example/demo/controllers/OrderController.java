package com.example.demo.controllers;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

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
	@RolesAllowed(value = {"ROLE_ADMIN","ROLE_USER"})
	public Order getOrder(Principal principal) {
		
		System.out.println("====Principal ========"+principal.getName());
		return firstOrder;
	}
	
	@GetMapping(path = "/orders/{id}")
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public Order getOrderById(@PathVariable("id") int id,Principal principal) {
		System.out.println("====Principal ========"+principal.getName());
		
		return secondOrder;
	}
	
}
