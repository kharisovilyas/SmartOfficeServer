package com.smartoffice.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class SmartOfficeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartOfficeServerApplication.class, args);
	}
}
