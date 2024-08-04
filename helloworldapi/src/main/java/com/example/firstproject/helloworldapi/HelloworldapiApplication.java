package com.example.firstproject.helloworldapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,XADataSourceAutoConfiguration.class})
@SpringBootApplication
public class HelloworldapiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloworldapiApplication.class, args);
	}
	
}
