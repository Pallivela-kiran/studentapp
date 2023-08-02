package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ExceptionMessage> ageExceptionHandler(IllegalFeildException exception)
	
	{
		ExceptionMessage exceptionMessage=new ExceptionMessage();
		exceptionMessage.setMessage(exception.getMessage());
		return new ResponseEntity<>(exceptionMessage,HttpStatus.BAD_REQUEST); 
	}
}
