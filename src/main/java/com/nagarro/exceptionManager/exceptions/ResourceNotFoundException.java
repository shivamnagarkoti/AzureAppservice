package com.nagarro.exceptionManager.exceptions;

import com.nagarro.constants.Constants;

public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldname;
	long fieldvalue;
	public ResourceNotFoundException(String resourceName, String fieldname, long fieldvalue) {
		super(String.format(Constants.RESOURCENOTFOUND,resourceName,fieldname,fieldvalue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	
}
