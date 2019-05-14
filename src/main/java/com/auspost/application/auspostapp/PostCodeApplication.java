package com.auspost.application.auspostapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.auspost.application.**" })
@EnableJpaRepositories("com.auspost.application.dao")
@EntityScan("com.auspost.application.model")
@EnableAutoConfiguration
public class PostCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostCodeApplication.class, args);
	}
}
