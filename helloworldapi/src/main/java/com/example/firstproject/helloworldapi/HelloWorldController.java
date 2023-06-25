package com.example.firstproject.helloworldapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/name")
	public List<Hello> sendHello(){
		return Arrays.asList(
				new Hello(1,"Hello", "Pravin"),
				new Hello(2,"Hello", "Ranga"),
				new Hello(3, "Hello","Shiva"),
				new Hello(4, "Hello","Ram"));
	}
}
