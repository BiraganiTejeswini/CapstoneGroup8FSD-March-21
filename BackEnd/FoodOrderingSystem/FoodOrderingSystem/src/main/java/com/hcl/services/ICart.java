package com.hcl.services;

import java.util.List;

import com.hcl.model.Cart;
import com.hcl.util.UserDefinedException;

public interface ICart {
	boolean deleteCartItems();

	Cart addCart(Cart cart);

	List<Cart> getItems();

	boolean deleteItem(int foodId) throws UserDefinedException;
}
