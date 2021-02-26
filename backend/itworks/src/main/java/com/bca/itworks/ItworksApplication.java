package com.bca.itworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bca.itworks")
public class ItworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItworksApplication.class, args);
	}

}
