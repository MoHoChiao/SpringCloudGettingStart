package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Part5ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Part5ConfigServerApplication.class, args);
	}
}
