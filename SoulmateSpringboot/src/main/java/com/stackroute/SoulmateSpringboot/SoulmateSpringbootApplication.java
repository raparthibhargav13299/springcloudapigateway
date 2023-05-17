package com.stackroute.SoulmateSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SoulmateSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoulmateSpringbootApplication.class, args);
	}

}
