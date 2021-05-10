package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;

@RestController
public class AccountController {

	
	 @Value("${server.port}")	
	   String portNumber;
		
	 
	 @Autowired
	 private Account account;
	
	@GetMapping(path = "/accounts")
	public Account getAccountInfo() {
		
		account.setAccountHolderName("Ramesh");
		account.setId(1010);
		account.setOutstanding(45000);
		account.setPortNumber(portNumber);
		
		return account;
	}
}
