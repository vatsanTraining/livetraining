package com.example.demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class RestaurantReview {

		int id;
		int restraurantId;
		String reviewedBy;
		String reviewAspect;
		String reviewBody;
		int reviewRating;

	
}
