package com.example.demo.controllers;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

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
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public Account getAccountInfo(Principal principal) {
		
		System.out.println("User In Role :="+ principal.getName());
			account.setPortNumber(portNumber);
			
		return account;
	}
	
	@GetMapping(path = "/accounts/info")
	@RolesAllowed(value = {"ROLE_USER"})
	public Account getAccount(Principal principal) {
		
		System.out.println("User In Role :="+ principal.getName());
			account.setPortNumber(portNumber+"user");
			
		return account;
	}
	
}
