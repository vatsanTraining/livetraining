package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.demo.services.FileService;

@SpringBootApplication
@EnableBinding(MySink.class)
public class CloudStreamConsumerApplication {

	
	@Autowired
	FileService service;
	
	@StreamListener("highValue")
    public void consumeHighValueOrders(String order) {
        System.out.println("Consume payload1 : " +order);
        service.save("high",order);
    }
	
	@StreamListener("normalValue")
    public void consumeNormalValueOrders(String order) {
        System.out.println("Consume payload2 : " +order);
        service.save("norm",order);

    }

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamConsumerApplication.class, args);
	}

}
