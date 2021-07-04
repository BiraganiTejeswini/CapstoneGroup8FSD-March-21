package com.hcl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderDetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderid")
	private int orderid;

	@Column(name = "totalquantity")
	private int totalquantity;

	@Column(name = "totalprice")
	private int totalprice;

	@ManyToOne(cascade = { CascadeType.ALL })
	private Address address;

	@ManyToOne(cascade = { CascadeType.ALL })
	private Customer customer;

}