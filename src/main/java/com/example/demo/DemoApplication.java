package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
		"com.example.demo.models"
})

@EnableJpaRepositories(basePackages = {
		 "com.example.demo.repositories"
})
@SpringBootApplication(scanBasePackages = {
		"com.example.demo.controllers"
}) 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
