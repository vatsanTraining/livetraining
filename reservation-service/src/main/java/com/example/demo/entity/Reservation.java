package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

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
@Table(name = "restaurant_reservation")

public class Reservation extends RepresentationModel<Reservation>{

	@Id
	private Long id;
	private LocalDateTime reservationDate;
	private List<Customer> customerList;

}
