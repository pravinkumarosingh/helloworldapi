package com.example.firstproject.helloworldapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,XADataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan("com.example.firstproject.helloworldapi")
public class HelloworldapiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloworldapiApplication.class, args);
	}
	
}
