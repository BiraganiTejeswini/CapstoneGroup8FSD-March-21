package com.hcl.token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hcl.model.Customer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenGeneratorImpl implements ITokenGenerator {

	@Override
	public Map<String, String> generateToken(Customer customer) {
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(customer.getEmail()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 10800000))
				.signWith(SignatureAlgorithm.HS256, "secretKey").compact();

		Map<String, String> map = new HashMap<String, String>();
		map.put("token", jwtToken);
		map.put("message", "Customer sucessfully logged in");
		return map;

	}

}
