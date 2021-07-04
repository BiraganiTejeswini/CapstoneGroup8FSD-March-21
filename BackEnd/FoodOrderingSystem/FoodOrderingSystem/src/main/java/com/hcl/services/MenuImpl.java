package com.hcl.services;

import com.hcl.model.Menu;
import com.hcl.repositry.*;
import com.hcl.util.UserDefinedException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuImpl implements IMenu {
	@Autowired
	private IMenuDAO menuDAO;

	@Autowired
	private ICartDAO cartDAO;

//to get menu details from the restuarant
	@Override
	public List<Menu> getdetailsByRestuarant(int rid) throws UserDefinedException {
		return menuDAO.findByRestuarant(rid);
	}

//to get food items based on the food name
	@Override
	public List<Menu> getFoodByName(String foodName) throws UserDefinedException {

		if (!menuDAO.findByFoodName(foodName).isEmpty()) {
			return menuDAO.findByFoodName(foodName);
		} else
			throw new UserDefinedException("Sorry!Food Item not Available.Select other Item");
	}

//to get food items based on food Price in ascending order
	@Override
	public List<Menu> getByFoodPrice() {

		return menuDAO.findByFoodPrice();
	}

//to get food items based on food Price in descending order
	@Override
	public List<Menu> getByFoodPriceDesc() {

		return menuDAO.findByFoodPriceDesc();
	}



}
