package com.example.demo.utils;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

	  @Output("highValue")
	  MessageChannel premium();

	  @Output("normalValue")
	  MessageChannel standard();

}
