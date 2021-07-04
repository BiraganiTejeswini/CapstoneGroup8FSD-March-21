package com.hcl.services;

import java.util.List;

import com.hcl.model.Menu;
import com.hcl.util.UserDefinedException;

public interface IRestuarant {
	List<Menu> getResturant(String name) throws UserDefinedException;
}
