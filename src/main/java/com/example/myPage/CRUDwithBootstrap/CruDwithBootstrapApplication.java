package com.example.myPage.CRUDwithBootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CruDwithBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDwithBootstrapApplication.class, args);
	}

}
