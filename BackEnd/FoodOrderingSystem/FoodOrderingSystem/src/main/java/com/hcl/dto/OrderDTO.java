package com.hcl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private int totalQuantity;
	private int totalPrice;
	private String city;
	private String country;
	private String state;
	private String street;
	private String zipcode;
}
