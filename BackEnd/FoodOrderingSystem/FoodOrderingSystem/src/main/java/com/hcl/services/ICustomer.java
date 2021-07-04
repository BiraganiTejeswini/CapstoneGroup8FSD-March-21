package com.hcl.services;

import com.hcl.model.Customer;



public interface ICustomer {
	Customer addCustomer(Customer customer) ;

	Customer getEmailAndPassword(String email, String password);

	Customer getByEmailId(String email) ;

}
