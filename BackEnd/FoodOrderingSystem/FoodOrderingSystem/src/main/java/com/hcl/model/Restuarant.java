package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restuarant")
public class Restuarant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restuarant_id")
	private int restuarantId;
	
	@NotNull(message = "Restuarant Name cannot be null")
	@Column(name = "restuarant_name")
	private String restuarantName;
	
	@NotNull(message = "Restuarant Location cannot be null")
	@Column(name = "restuarant_location")
	private String restuarantLocation;
}
