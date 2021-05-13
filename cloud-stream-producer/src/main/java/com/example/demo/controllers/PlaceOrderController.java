package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.services.OrderService;

@RestController
public class PlaceOrderController {

	
	@Autowired
	private OrderService service;
	
	@PostMapping(path = "/api/v1/orders")
	public ResponseEntity<String> addOrders(@RequestBody Order entity) {
		
		boolean  isSent = service.send(entity);
		
		String status ="Order Accepted";
		if(!isSent) {
			
			status ="Order Not Accepted";
		}
		
		return ResponseEntity.ok(entity.toString().concat(status));
		
		
		
	}
}
