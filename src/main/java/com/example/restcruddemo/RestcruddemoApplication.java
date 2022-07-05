package com.example.restcruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = "com.example.entities")
@EnableJpaRepositories(basePackages = "com.example.dao")
@ComponentScan(basePackages = {"com.example.controllers","com.example.services"})
@EnableSwagger2
@EnableWebMvc
public class RestcruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestcruddemoApplication.class, args);
	}

}
