package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig  {

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/actuator")
		.permitAll().antMatchers("/api/v1/**").authenticated().and().oauth2Login();
		
		
	
	}

	
}
