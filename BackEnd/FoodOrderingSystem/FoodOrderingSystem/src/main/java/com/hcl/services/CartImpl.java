package com.hcl.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.model.Cart;
import com.hcl.repositry.ICartDAO;
import com.hcl.util.UserDefinedException;

@Service
public class CartImpl implements ICart {
	@Autowired
	ICartDAO cartDAO;

//to add the items into the cart
	@Override
	public Cart addCart(Cart cart) {
		return cartDAO.saveAndFlush(cart);
	}

//to get all the items from the cart
	@Override
	public List<Cart> getItems() {
		return cartDAO.findAll();
	}

//to delete single item from the cart
	@Override
	public boolean deleteItem(int foodId) throws UserDefinedException {

		if (cartDAO.findById(foodId).isPresent()) {
			cartDAO.deleteById(foodId);
			return true;
		} else
			throw new UserDefinedException("FoodID dosen't exists can't delete");
	}

//to delete all items from the cart
	@Override
	public boolean deleteCartItems() {
		cartDAO.deleteAll();
		return true;

	}
}