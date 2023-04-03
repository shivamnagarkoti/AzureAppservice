package com.nagarro.exceptionManager.exceptions;

import com.nagarro.constants.Constants;

public class UserAlreadyExists extends RuntimeException {
	String resourceName;
	String fieldname;
	
	public UserAlreadyExists(String resourceName, String fieldname) {
		super(String.format(Constants.USERALREADYEXIST,resourceName,fieldname));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		
	}
}
