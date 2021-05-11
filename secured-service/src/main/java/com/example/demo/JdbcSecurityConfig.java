package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(
                "SELECT username, password, enabled from users where username = ?")
            .authoritiesByUsernameQuery(
                "SELECT u.username, a.authority " +
                "FROM authorities a, users u " +
                "WHERE u.username = ? " +
                "AND u.username = a.username"
            )
        .passwordEncoder(encoder());

	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		  http.authorizeRequests().antMatchers("/orders/**")
		               .authenticated().and().httpBasic();
	
	}

	@Bean
	public BCryptPasswordEncoder encoder() {

	return new BCryptPasswordEncoder();
	}

}
