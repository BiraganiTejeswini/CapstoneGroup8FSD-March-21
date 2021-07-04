package com.hcl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Address;
import com.hcl.services.IAddressImpl;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
@Validated
public class AddressController {

	@Autowired
	private IAddressImpl addressService;

//to add the address
	@PostMapping(value = "/address")
	public ResponseEntity<Address> postAddress(@Valid @RequestBody Address address) {
		try {
			Address address1 = addressService.addAddress(address);
			return new ResponseEntity<>(address1, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
