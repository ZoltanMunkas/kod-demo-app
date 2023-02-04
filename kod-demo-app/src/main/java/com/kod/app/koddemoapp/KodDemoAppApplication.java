package com.kod.app.koddemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.kod.app.koddemoapp")
public class KodDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodDemoAppApplication.class, args);
	}
}
