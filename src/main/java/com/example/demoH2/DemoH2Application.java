package com.example.demoH2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoH2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoH2Application.class, args);
	}

}
