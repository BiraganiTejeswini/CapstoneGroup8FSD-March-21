package com.hcl.services;

import com.hcl.model.Address;
import com.hcl.repositry.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressImpl implements IAddressImpl {

	@Autowired
	private IAddressDAO adressDAO;

//to add the address details
	@Override
	public Address addAddress(Address address) {
		Address address1 = adressDAO.save(address);
		return address1;
	}
}
