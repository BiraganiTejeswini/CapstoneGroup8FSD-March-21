package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	private int foodId;

	@NotNull(message = "Food_category cannot be null")
	@Column(name = "food_category")
	private String foodCategory;

	@NotNull(message = "imageUrl cannot be null")
	@Column(name = "imageUrl")
	private String imageUrl;

	@NotNull(message = "Food_name cannot be null")
	@Column(name = "food_name")
	private String foodName;

	@NotNull(message = "Food_Price cannot be null")
	@Column(name = "food_price")
	private double foodPrice;

	@NotNull(message = "quantity cannot be null")
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	private Restuarant restuarant;

}
