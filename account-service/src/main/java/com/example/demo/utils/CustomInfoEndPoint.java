package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
@Component
public class CustomInfoEndPoint implements InfoContributor {

	@Autowired
	ConfigurableApplicationContext ctx;
	
	@Override
	public void contribute(Builder builder) {

		
		Map<String, Object> details = new HashMap<>();
        details.put("bean-definition-count", ctx.getBeanDefinitionCount());
        
        long startup =ctx.getStartupDate();
         
        Date date = new Date(startup);
        
        Instant inst =date.toInstant();
        
        
        details.put("startup-date",LocalDate.ofInstant(inst,ZoneId.systemDefault()) );

        builder.withDetail("context", details);

	}

}
