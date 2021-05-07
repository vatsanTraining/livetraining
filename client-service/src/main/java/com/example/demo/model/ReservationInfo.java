package com.example.demo.model;

import org.springframework.hateoas.CollectionModel;

import com.example.demo.controllers.ReviewsDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor()
@NoArgsConstructor

public class ReservationInfo {

	

		
		RestaurantDTO restaurant;
		CollectionModel<ReservationDto>  reservation;
		
	}

