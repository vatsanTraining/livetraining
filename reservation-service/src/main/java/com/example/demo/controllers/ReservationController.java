package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reservation;
import com.example.demo.repo.ReservationRepository;
import java.util.*;
@RestController
public class ReservationController {

	
	@Autowired
	private ReservationRepository repo;
	
	
	
	@GetMapping(path = "/api/v1/reservations")
	public CollectionModel<Reservation> findAll(){
		
		List<Reservation> list = this.repo.findAll();
		
		
		return null;
		
	}
}
