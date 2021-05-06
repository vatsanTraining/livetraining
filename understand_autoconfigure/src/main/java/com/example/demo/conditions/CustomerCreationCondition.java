package com.example.demo.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomerCreationCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		boolean result = false;
		
		 String os = context.getEnvironment().getProperty("os.name");
		
		 
		 if(os.equalsIgnoreCase("Windows 10")) {
			 result =true;
		 }
		 
		return result;
	}

}
