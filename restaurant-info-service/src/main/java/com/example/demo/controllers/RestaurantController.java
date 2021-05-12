package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.services.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class RestaurantController {

	
	
	private RestaurantService service;

	@Autowired
	public void setService(RestaurantService service) {
		this.service = service;
	}
	
	
	@GetMapping(path = "/restaurants")
	@Operation(description =  "Used to Find All the Restaurants")
	public List<RestaurantInfo> findAll(){
		log.info("Find all Method called");
		return this.service.getAll();
	}
	
	@GetMapping(path = "/restaurants/{id}")
	@Operation(description =  "Used to Find Restaurants by Unique Id")

	public RestaurantInfo findById(@PathVariable("id") int id){
		
		log.info("Find By Id Called");
		return this.service.getById(id)
				   .orElseThrow(()-> new RuntimeException("Element with Given Id Not found"));
	
	}
	
	@GetMapping(path = "/restaurants/srch/{name}")
	@Operation(description =  "Used to Find Restaurants by its Name")

	public RestaurantInfo findByName(@PathVariable("name") String srchName){
		
		return this.service.searchByName(srchName);
	
	}
	
	
	@PostMapping(path = "/restaurants")
	public ResponseEntity<RestaurantInfo> addInfo(@RequestBody RestaurantInfo entity){
		
		RestaurantInfo added = service.save(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(added);
	}
	
	@PutMapping(path = "/restaurants")
	public ResponseEntity<RestaurantInfo> updateInfo(@RequestBody RestaurantInfo entity){
		
		RestaurantInfo added = service.save(entity);
		
		return ResponseEntity.status(HttpStatus.OK).body(added);
	}
	
	@PatchMapping(path = "/restaurants/update/{id}/{newTiming}")
	public ResponseEntity<String> updateTiming(@PathVariable("id") int id,@PathVariable("newTiming") String newTiming){
	
		  int count = this.service.updateTiming(id, newTiming);
		  
		  return ResponseEntity.ok("Rows Updated :="+count);
		}
	
	@DeleteMapping(path = "/restaurants")
	public RestaurantInfo remove(@RequestBody RestaurantInfo entity){
		

		return this.service.remove(entity).orElseThrow(()-> new RuntimeException("Element With Given Id Not found"));
	}
	
}
