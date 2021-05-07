package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	public List<Reservation> findByRestaurantName(String srchName);
}
