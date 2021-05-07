package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.autoconfigure.DevToolsProperties.Restart;
import org.springframework.stereotype.Service;
import java.util.*;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.repos.RestaurantInfoRepository;

@Service
public class RestaurantService {

	
	private RestaurantInfoRepository repo;

	@Autowired
	public RestaurantService(RestaurantInfoRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<RestaurantInfo> getAll(){
		
		return this.repo.findAll();
	}
	
  public RestaurantInfo save(RestaurantInfo entity){
		
		return this.repo.save(entity);
	}
  
  
  public Optional<RestaurantInfo> getById(int id) {
	  
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
