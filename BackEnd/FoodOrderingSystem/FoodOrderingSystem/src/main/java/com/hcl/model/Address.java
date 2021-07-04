package com.hcl.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressid")
	private int addressid;

	@NotNull(message = "city cannot be null")
	@Column(name = "city")
	private String city;

	@NotNull(message = "country cannot be null")
	@Column(name = "country")
	private String country;

	@NotNull(message = "state cannot be null")
	@Column(name = "state")
	private String state;

	@NotNull(message = "street cannot be null")
	@Column(name = "street")
	private String street;

	@NotNull(message = "zipcode cannot be null")
	@Column(name = "zipcode")
	private String zipcode;

	@OneToOne
	@PrimaryKeyJoinColumn
	private OrderDetails order;

}
