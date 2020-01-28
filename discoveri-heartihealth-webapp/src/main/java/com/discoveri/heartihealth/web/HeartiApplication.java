package com.discoveri.heartihealth.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.discoveri.heartihealth")
public class HeartiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeartiApplication.class, args);
	}
}
