package com.project.restproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.project.restproject.repository")
public class RestProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestProjectApplication.class, args);
	}

}
