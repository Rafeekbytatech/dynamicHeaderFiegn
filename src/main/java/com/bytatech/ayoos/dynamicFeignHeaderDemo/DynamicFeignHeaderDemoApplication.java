package com.bytatech.ayoos.dynamicFeignHeaderDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DynamicFeignHeaderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicFeignHeaderDemoApplication.class, args);
	}

}
