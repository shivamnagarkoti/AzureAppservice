package com.nagarro.exceptionManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.exceptionManager.exceptions.ResourceNotFoundException;
import com.nagarro.exceptionManager.exceptions.UserAlreadyExists;

@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<ApiResponse> userAlreadyexistsExceptionHandler(UserAlreadyExists ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	

}
