package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor()
@NoArgsConstructor

@Entity
@Table(name = "restaurants")
public class RestaurantInfo {

	@Id
    private int id;
    private String name;
    private String serviceArea;
    private String emailAddress;
    private String menuType;
    private String openingHours;

}
