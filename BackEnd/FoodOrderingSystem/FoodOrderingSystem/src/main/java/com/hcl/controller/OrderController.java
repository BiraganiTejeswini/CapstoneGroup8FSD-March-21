package com.hcl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.dto.OrderDTO;
import com.hcl.model.Address;
import com.hcl.model.Customer;
import com.hcl.model.OrderDetails;
import com.hcl.services.ICustomer;
import com.hcl.services.OrderImpl;
import com.hcl.token.ITokenGenerator;
import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class OrderController {
	@Autowired
	private OrderImpl orderService;

	@Autowired
	ITokenGenerator tokenGenerator;

	@Autowired
	private ICustomer customerService;

//to store ordered details into table
	@PostMapping("/addOrderDetails")
	public ResponseEntity<Boolean> addOrderDetails(@RequestBody OrderDTO addressDto, HttpServletRequest request) {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setTotalprice(addressDto.getTotalPrice());
		orderDetails.setTotalquantity(addressDto.getTotalQuantity());
		final String authHeader = request.getHeader("authorization");
		System.out.println("From frontend: " + addressDto);
		System.out.println(authHeader);
		final String token = authHeader.substring(7);
		System.out.println(token);
		String email = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody().getSubject();
		System.out.println(email + "frontend return");
		Address address = new Address();
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setState(addressDto.getState());
		address.setZipcode(addressDto.getZipcode());
		address.setStreet(addressDto.getStreet());
		Customer customer = customerService.getByEmailId(email);
		orderDetails.setCustomer(customer);
		orderDetails.setAddress(address);
		System.out.println("Angular Data: " + orderDetails);
		return new ResponseEntity<Boolean>(orderService.addOrderDetails(orderDetails), HttpStatus.OK);

	}

}
