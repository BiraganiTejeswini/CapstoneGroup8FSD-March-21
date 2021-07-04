package com.hcl.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDefinedException extends Exception {
	private static final long serialVersionUID = 1L;
	private String msg;

	public UserDefinedException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}

}
