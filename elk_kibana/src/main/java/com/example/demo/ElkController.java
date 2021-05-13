package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ElkController {

	
	@GetMapping("/")
    public String home() {
		log.info("Calling ElK Controller Home Method");
        return "home";
    }

@GetMapping(path = "/reviews/{id}")
public String getReviews(@PathVariable("id") int id) {
	
	if(id< 5) {
		log.info("Less than 5 condition called");
		return "Average rating 4.5 out of 1230";
	} else {
		log.info("Greater than 5 called");
		return "Average rating 3.5 out of 2230";
	}
}
}
