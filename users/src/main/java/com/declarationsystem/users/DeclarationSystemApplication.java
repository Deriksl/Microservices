package com.declarationsystem.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.declarationsystem.controller", "com.declarationsystem.service"})
public class DeclarationSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeclarationSystemApplication.class, args);
	}
}
