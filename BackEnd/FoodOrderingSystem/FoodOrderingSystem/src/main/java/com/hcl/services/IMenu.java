package com.hcl.services;

import java.util.List;

import com.hcl.util.UserDefinedException;
import com.hcl.model.Cart;
import com.hcl.model.Menu;

public interface IMenu {
	List<Menu> getdetailsByRestuarant(int rid) throws UserDefinedException;

	List<Menu> getFoodByName(String foodName) throws UserDefinedException;
	
	List<Menu> getByFoodPrice() ;
	
	List<Menu> getByFoodPriceDesc() ;

}
