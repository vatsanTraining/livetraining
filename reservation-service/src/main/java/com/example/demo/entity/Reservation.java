package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor()
@NoArgsConstructor
@Entity
@Table(name = "restaurant_reservation")

public class Reservation extends RepresentationModel<Reservation>{

	@Id
	private Long id;
	private String restaurantName;
	private LocalDateTime reservationDate;
	
	@OneToMany(targetEntity =Customer.class,  
			cascade = CascadeType.ALL,
			            fetch=FetchType.EAGER)
			    @JoinColumn(name = "customer_ref" , referencedColumnName = "id")
			 
			@JsonIgnore
           private List<Customer> customerList;

}
