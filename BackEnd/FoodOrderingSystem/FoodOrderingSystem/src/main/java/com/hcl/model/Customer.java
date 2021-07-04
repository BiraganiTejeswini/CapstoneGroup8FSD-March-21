package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;

	@NotNull(message = "FirstName cannot be null")
	@Size(min = 2, message = "Atleast Two  characters needed")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "LastName cannot be null")
	@Size(min = 2, message = "Atleast Two  characters needed")
	@Column(name = "last_name")
	private String lastName;

	@Email(message = "Email should be valid")
	@NotNull(message = "Email cannot be null")
	@Column(name = "email", unique = true)
	private String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 6, max = 15, message = "paswword length should be between 6 to 15 charcaters")
	@Column(name = "password")
	private String password;

}
