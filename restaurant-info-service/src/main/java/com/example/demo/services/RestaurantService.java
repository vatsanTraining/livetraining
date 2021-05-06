package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
}
