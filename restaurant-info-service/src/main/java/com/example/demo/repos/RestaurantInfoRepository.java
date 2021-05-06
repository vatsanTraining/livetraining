package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RestaurantInfo;

public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Integer> {

}
