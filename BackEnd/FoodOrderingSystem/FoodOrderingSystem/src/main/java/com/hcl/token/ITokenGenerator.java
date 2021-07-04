package com.hcl.token;

import java.util.Map;

import com.hcl.model.Customer;

public interface ITokenGenerator {
	public Map<String, String> generateToken(Customer customer);
}
