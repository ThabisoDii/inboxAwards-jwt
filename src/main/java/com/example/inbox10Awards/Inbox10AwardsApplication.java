package com.example.inbox10Awards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Inbox10AwardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Inbox10AwardsApplication.class, args);
	}

}
