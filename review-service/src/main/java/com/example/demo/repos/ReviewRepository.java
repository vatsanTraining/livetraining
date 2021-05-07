package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Review;

@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	public Review findByRestaurantName(String srchName);
}
