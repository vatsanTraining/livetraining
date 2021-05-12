package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.model.ErrrorHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ErrrorHandler  handleAllExceptions(Exception e, WebRequest request) {
		
		log.info("Exception :="+ e.getMessage());
		
		return new ErrrorHandler(LocalDateTime.now(),e.getMessage(),request.getDescription(false));
		
	}
}
