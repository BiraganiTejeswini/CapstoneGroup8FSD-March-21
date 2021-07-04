package com.hcl.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.OrderDetails;
import com.hcl.repositry.IOrderDAO;

@Service
public class OrderImpl implements IOrder {

	@Autowired
	private IOrderDAO orderDAO;

//to save the order details
	@Override
	@Transactional
	public boolean addOrderDetails(OrderDetails order) {
		OrderDetails o = orderDAO.save(order);
		System.out.println("My service : " + o);
		return true;
	}

}
