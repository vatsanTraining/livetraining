package com.example.demo.model;

import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class Invoice {

	private int invoiceNumber;
	private Customer customer;
	private Product product;

}
