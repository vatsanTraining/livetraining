package com.example.demo.controllers;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor()
@NoArgsConstructor

public class ReviewsDTO {
	int id;
	String restaurantName;
	String reviewedBy;
	String reviewAspect;
	String reviewBody;
	double reviewRating;

}