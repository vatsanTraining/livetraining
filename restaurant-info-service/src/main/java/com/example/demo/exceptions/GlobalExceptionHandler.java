package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.model.ErrrorHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ErrrorHandler  handleAllExceptions(Exception e, WebRequest request) {
		
		
		return new ErrrorHandler(LocalDateTime.now(),e.getMessage(),request.getDescription(false));
		
	}
}
