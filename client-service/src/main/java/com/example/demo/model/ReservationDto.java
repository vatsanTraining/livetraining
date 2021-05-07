package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor()
@NoArgsConstructor


public class ReservationDto {

	private Long id;
	private String restaurantName;
	private LocalDateTime reservationDate;
	
	private List<Customer> customerList;

	
	
}
