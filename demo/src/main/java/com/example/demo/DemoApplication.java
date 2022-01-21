package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//AutoConfiguration.. (컨피그 자동 구성?)

@SpringBootApplication
public class DemoApplication {

	//contorller --> new service --> new repository

	// <Bean..
	// <Component-scan..>


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
