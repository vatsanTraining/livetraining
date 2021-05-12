package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.stereotype.Service;
import java.util.*;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.repos.RestaurantInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestaurantService {

	
	private RestaurantInfoRepository repo;

	@Autowired
	public RestaurantService(RestaurantInfoRepository repo) {
		super();
		log.info("Restaurant Info Service Initialized");
		this.repo = repo;
	}
	
	
	@NewSpan(name = "getAllRestaurnt")
	public List<RestaurantInfo> getAll(){
		
		log.info("Restaurant Info Get All Method in service Called");

		return this.repo.findAll();
	}
	
  public RestaurantInfo save(RestaurantInfo entity){
		
		return this.repo.save(entity);
	}
  
  
  @NewSpan(name = "findById")
  public Optional<RestaurantInfo> getById(@SpanTag("find") int id) {
	  
	  return this.repo.findById(id);
  }
  
public RestaurantInfo update(RestaurantInfo entity) {
	    
	  return this.repo.save(entity);
  }

public Optional<RestaurantInfo> remove(RestaurantInfo entity) {
	  
	Optional<RestaurantInfo> optional = Optional.empty();  
	
	 if(this.repo.existsById(entity.getId())) {
		 
		 this.repo.delete(entity);
		 optional = Optional.of(entity);
	 }
	  
	 return optional;
}


public RestaurantInfo searchByName(String srchName) {
	
	return this.repo.findByName(srchName);
}
  

public int  updateTiming(int id, String newTiming) {
	
	return this.repo.updateOpeningHours(id, newTiming);
}
	
	
	
}
