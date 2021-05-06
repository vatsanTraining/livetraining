package com.example.demo.model;

import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

	private int customerId;
	private String customerName;
	private String email;

}
