package com.bill;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
		System.out.println("done");
	}
		
	@Bean
	public ModelMapper modelMaper() {
		return new ModelMapper();
	}
}
