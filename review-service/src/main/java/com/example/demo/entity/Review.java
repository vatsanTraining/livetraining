package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor()
@NoArgsConstructor

@Entity
@Table(name = "restaurant_reviews")
public class Review {

	@Id
	int id;
	String restaurantName;
	String reviewedBy;
	String reviewAspect;
	String reviewBody;
	double reviewRating;

}
