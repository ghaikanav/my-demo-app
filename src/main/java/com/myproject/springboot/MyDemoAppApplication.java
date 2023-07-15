package com.myproject.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDemoAppApplication.class, args);
	}

}
