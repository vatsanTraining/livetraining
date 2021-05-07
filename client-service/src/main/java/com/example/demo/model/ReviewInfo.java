package com.example.demo.model;

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

public class ReviewInfo {

	
	RestaurantDTO restaurant;
	ReviewsDTO  review;
	
}
