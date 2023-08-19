package com.capstone.doconnect;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@CrossOrigin
public class DoConnectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoConnectBackendApplication.class, args);
	}

	@Bean
	public  RestTemplate getRestTemplate() {
		
		
		return new RestTemplate();
	}
}
