package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {

	@Input("highValue")
	  SubscribableChannel sourceOfHighValue();
	
	@Input("normalValue")
	  SubscribableChannel sourceOfNormalValue();
	

}
