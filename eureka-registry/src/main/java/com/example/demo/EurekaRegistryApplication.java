package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.eureka.EurekaServerConfig;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(EurekaRegistryApplication.class, args);
		
		System.out.println(ctx.getBean(EurekaInstanceConfig.class));
		System.out.println(ctx.getBean(EurekaServerConfig.class));
		
	}

}
