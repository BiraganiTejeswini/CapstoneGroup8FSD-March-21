package com.hcl.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.model.Customer;
import com.hcl.services.ICustomer;
import com.hcl.token.ITokenGenerator;
import com.hcl.util.UserDefinedException;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
@Validated
public class CustomerController {
	@Autowired
	private ICustomer customerService;

	@Autowired
	ITokenGenerator tokenGenerator;

//to get the customer details based on the emailId
	@GetMapping("/getCustomerDetails/{email}")
	public ResponseEntity<?> getCustomerOnEmail(@PathVariable String email) throws UserDefinedException {
		Customer c = customerService.getByEmailId(email);
		if (c != null) {
			return new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Email Id not Found", HttpStatus.NOT_FOUND);
	}

//to add customer for signup
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		System.out.println(customer);
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
	}

//to allow user for login
	@GetMapping("/getCredentails/{email}/{password}")
	public ResponseEntity<?> getCredentials(@PathVariable String email, @PathVariable String password) {
		// System.out.println(customer);
		// Customer c = customerService.getEmailAndPassword(customer.getEmail(),
		// customer.getPassword());
		System.out.println(email + "" + password);

		Customer c = customerService.getEmailAndPassword(email, password);
		System.out.println(c);
		if (c != null) {
			Map<String, String> map = tokenGenerator.generateToken(c);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Email and Password is incorrect", HttpStatus.NOT_FOUND);
	}

}
