package com.example.demo.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor()
@NoArgsConstructor


public class RestaurantDTO {

	private int id;
    private String name;
    private String serviceArea;
    private String emailAddress;
    private String menuType;
    private String openingHours;

}
