package com.hcl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.model.Customer;
import com.hcl.repositry.ICustomerDAO;

@Service
public class CustomerImpl implements ICustomer {
	@Autowired
	private ICustomerDAO customerDAO;

//to add the customer for signup
	@Override
	public Customer addCustomer(Customer customer) {
		return customerDAO.saveAndFlush(customer);
	}

//to get email and password to login
	@Override
	public Customer getEmailAndPassword(String email, String password) {
		return customerDAO.findByEmailAndPassword(email, password);
	}

//to get customer details based on the emailid
	@Override
	public Customer getByEmailId(String email) {
		return customerDAO.findByEmail(email);
	}

}
