package com.hcl.model;

import javax.persistence.*;
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
@Table(name = "state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id")
	private int stateId;

	@NotNull(message = "StateName cannot be null")
	@Column(name = "state_name")
	private String stateName;

}
