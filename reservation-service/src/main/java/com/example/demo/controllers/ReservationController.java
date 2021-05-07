package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Reservation;
import com.example.demo.repo.ReservationRepository;
import java.util.*;
@RestController
public class ReservationController {

	
	@Autowired
	private ReservationRepository repo;
	
	
	@GetMapping(path = "/api/v1/reservations/{srchName}")
	public CollectionModel<Reservation> findByName(@PathVariable("srchName") String name){
		
		List<Reservation> list = this.repo.findByRestaurantName(name);
		
		
		
for(Reservation eachReservation: list) {
			
			List<Customer> custList = eachReservation.getCustomerList();
			
			   for(Customer eachCustomer: custList) {
				   		   
				   Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class)
						      .slash("customers/"+eachCustomer.getId()).withSelfRel();
				   
				   eachReservation.add(selfLink);
			   }
		}
		
		Link  link =WebMvcLinkBuilder.linkTo(ReservationController.class).withSelfRel();
		
		return CollectionModel.of(list,link);
			}
	
	
	@GetMapping(path = "/api/v1/reservations")
	public CollectionModel<Reservation> findAll(){
		
		List<Reservation> list = this.repo.findAll();
		
		for(Reservation eachReservation: list) {
			
			List<Customer> custList = eachReservation.getCustomerList();
			
			   for(Customer eachCustomer: custList) {
				   		   
				   Link selfLink = WebMvcLinkBuilder.linkTo(CustomerController.class)
						      .slash("customers/"+eachCustomer.getId()).withSelfRel();
				   
				   eachReservation.add(selfLink);
			   }
		}
		
		Link  link =WebMvcLinkBuilder.linkTo(ReservationController.class).withSelfRel();
		
		return CollectionModel.of(list,link);
		
		
	}
}
