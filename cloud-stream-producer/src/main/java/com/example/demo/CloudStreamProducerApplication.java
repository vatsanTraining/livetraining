package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import com.example.demo.utils.MySource;

@SpringBootApplication
@EnableBinding(value = MySource.class)
public class CloudStreamProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamProducerApplication.class, args);
	}

}
