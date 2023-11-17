package com.cos.capybara;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class CapybaraBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapybaraBackendApplication.class, args);
	}
}
