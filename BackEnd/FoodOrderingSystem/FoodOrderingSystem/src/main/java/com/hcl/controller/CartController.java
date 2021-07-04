package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.model.Cart;
import com.hcl.model.Customer;
import com.hcl.services.ICart;
import com.hcl.services.ICustomer;
import com.hcl.token.ITokenGenerator;
import com.hcl.util.UserDefinedException;

import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")

public class CartController {

	@Autowired
	private ICart cartService;
	@Autowired
	ITokenGenerator tokenGenerator;
	@Autowired
	private ICustomer customerService;

//to add the items into cart
	@PostMapping("/addCart")
	public ResponseEntity<Cart> saveCart(@Valid @RequestBody Cart cart, HttpServletRequest request) {
		final String authHeader = request.getHeader("authorization");
		System.out.println(authHeader);
		final String token = authHeader.substring(7);
		System.out.println(token);
		String email = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody().getSubject();
		System.out.println(email + "frontend return");
		Customer customer = customerService.getByEmailId(email);
		System.out.println(customer + "Cart Controleerr..");
		cart.setCustomer(customer);
		System.out.println(cart);
		return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.OK);
	}

//to get the items stored in the cart
	@GetMapping(value = "/getCart")
	public ResponseEntity<List<Cart>> getAllItems() {
		List<Cart> items = new ArrayList<Cart>();
		try {
			items = cartService.getItems();

			if (items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//to delete the food item in tha cart
	@DeleteMapping("/delete/{foodId}")
	public ResponseEntity<String> deleteItem(@PathVariable("foodId") int foodId) throws UserDefinedException {
		cartService.deleteItem(foodId);
		System.out.println("delete");
		return new ResponseEntity<String>("Deleted successfully.!", HttpStatus.OK);
	}

//to delete all cart Items from the cart
	@DeleteMapping("/deleteCartItems")
	public ResponseEntity<Boolean> deleteAllItems() {
		return new ResponseEntity<Boolean>(cartService.deleteCartItems(), HttpStatus.OK);
	}

}
