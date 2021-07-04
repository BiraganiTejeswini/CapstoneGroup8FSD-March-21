package com.hcl.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hcl.model.Menu;
import com.hcl.services.IMenu;
import com.hcl.services.IRestuarant;
import com.hcl.util.UserDefinedException;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class FoodController {
	@Autowired
	private IRestuarant restuarantService;
	@Autowired
	private IMenu menuService;

//to get the list of items in particular restuarant
	@GetMapping("/restuarantName/{rname}")
	public ResponseEntity<List<Menu>> displayRestuarantMenu(@PathVariable String rname) throws UserDefinedException {
		System.out.println(rname);
		List<Menu> mList = restuarantService.getResturant(rname);
		System.out.println(mList);
		return new ResponseEntity<List<Menu>>(mList, HttpStatus.OK);

	}

//to search food item based on food name
	@GetMapping("/searchByFood/{name}")
	public ResponseEntity<List<Menu>> searchByFoodName(@PathVariable String name) throws UserDefinedException {
		System.out.println("search Name" + name);
		return new ResponseEntity<List<Menu>>(menuService.getFoodByName(name), HttpStatus.OK);
	}

//to get food item based on FoodPrice
	@GetMapping("/getByPriceAsc")
	public ResponseEntity<List<Menu>> getByFoodPrice() {

		return new ResponseEntity<List<Menu>>(menuService.getByFoodPrice(), HttpStatus.OK);
	}

//to get food item based on FoodPrice
	@GetMapping("/getByPriceDesc")
	public ResponseEntity<List<Menu>> getByFoodPriceDesc() {

		return new ResponseEntity<List<Menu>>(menuService.getByFoodPriceDesc(), HttpStatus.OK);
	}

}
