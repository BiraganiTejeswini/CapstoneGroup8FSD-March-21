package com.hcl.services;

import com.hcl.model.Menu;
import com.hcl.model.Restuarant;
import com.hcl.repositry.*;
import com.hcl.util.UserDefinedException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestuarantImpl implements IRestuarant {
	@Autowired
	private IMenu menuDAO;
	@Autowired
	private IRestuarantDAO restuarantDAO;

//to get restuarant details based on restuarantname
	@Override
	public List<Menu> getResturant(String name) throws UserDefinedException {
		Restuarant r = restuarantDAO.findByRestuarantName(name);
		System.out.println("restuarant record" + r);

		if (r != null) {
			List<Menu> menuList = menuDAO.getdetailsByRestuarant(r.getRestuarantId());
			return menuList;
		} else {
			throw new UserDefinedException("Restuarant Not found");
		}

	}

}
