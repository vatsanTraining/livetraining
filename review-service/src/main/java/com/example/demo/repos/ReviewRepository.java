package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entity.Review;
import java.util.*;
@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Integer> {


	@RestResource(path = "names" )
	public Review findByRestaurantName(String srchName);
	@RestResource(path = "rating" )
	public List<Review> findByReviewRatingGreaterThan(double srchValue);
}
