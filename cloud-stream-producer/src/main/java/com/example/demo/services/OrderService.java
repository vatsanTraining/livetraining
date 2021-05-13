package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;

@Service
public class OrderService {

	@Autowired
	@Qualifier("highValue")
	private MessageChannel high;

	@Autowired
	@Qualifier("normalValue")
	private MessageChannel standard;

	
	public boolean send(Order entity) {
		
		boolean resp =true;
		if(entity.getValue()>5000) {
		 resp= high.send(MessageBuilder.withPayload(entity).build());
		} else {
			 resp= standard.send(MessageBuilder.withPayload(entity).build());
		}
				return resp;
	}
	
}
