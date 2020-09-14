package com.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.webservice"})
public class FeatureRequestAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeatureRequestAppApplication.class, args);
	}

}
