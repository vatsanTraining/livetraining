package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;



@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(WebClientResponseException.class)
	public ResponseEntity<String> handleException(WebClientResponseException ex) {
		
		
		return ResponseEntity.status(ex.getRawStatusCode())
		  .body(ex.getResponseBodyAsString());

}
	
}
