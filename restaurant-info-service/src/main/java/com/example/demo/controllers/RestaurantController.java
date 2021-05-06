package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.services.RestaurantService;
import java.util.*;
@RestController
@RequestMapping(path = "/api/v1")
public class RestaurantController {

	
	
	private RestaurantService service;

	@Autowired
	public void setService(RestaurantService service) {
		this.service = service;
	}
	
	
	@GetMapping(path = "/restaurants")
	public List<RestaurantInfo> findAll(){
		
		return this.service.getAll();
	}
	
	
	@PostMapping(path = "/restaurants")
	public ResponseEntity<RestaurantInfo> addInfo(@RequestBody RestaurantInfo entity){
		
		RestaurantInfo added = service.save(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(added);
	}
	
}
