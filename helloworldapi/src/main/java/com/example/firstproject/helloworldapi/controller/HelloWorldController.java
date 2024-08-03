package com.example.firstproject.helloworldapi.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.firstproject.helloworldapi.service.HelloWorldService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import com.example.firstproject.helloworldapi.model.Hello;
import com.example.firstproject.helloworldapi.repository.HelloSpringDataJpaRepository;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@Component
@Tag(name = "Hello World Controller", description = "Api to add new update users")
public class HelloWorldController {

	
	@Autowired
	public HelloSpringDataJpaRepository helloSpringDataJpaRepository;

	@Autowired
	private HelloWorldService helloWorldService;
	
	private static final Logger LOGGER = LogManager.getLogger(HelloWorldController.class);
	
	@Cacheable("myCache")
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String testURL() {
		LOGGER.info("Test URL Fetched");
		return "This is Test URL";
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Hello> getData(HttpServletRequest request){
		int port = request.getLocalPort();
		if(port != 9090){
			return new ArrayList<>();
		}
		return helloSpringDataJpaRepository.findAll();
	}

	@Operation(summary = "API to add new person in database", description = "Adds a new person")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void setData(@RequestBody Hello hello) {
		LOGGER.info("Hello -> {}", hello);
		helloWorldService.saveHello(hello);
	}

	@Operation(summary = "Get detail by ID", description = "API to get details of person by their associated ID")
	@ApiResponse(responseCode = "200", description = "Successful Response")
	@ApiResponse(responseCode = "404", description = "User not found")
	@RequestMapping(value= "/getById", method = RequestMethod.GET)
	public Hello getDataById(@RequestParam(name="id") int id) {
		Hello hello = helloSpringDataJpaRepository.findById(id);
		LOGGER.info("Hello -> {}", hello);
        return hello;
	}
	
//	@RequestMapping(value= "/getByName", method = RequestMethod.GET)
//	public Optional<Hello> getDataByName(@RequestParam(name="firstname") String firstname) {
//		Optional<Hello> hello = Optional.ofNullable(new Hello());
//		hello =  Optional.ofNullable(helloSpringDataJpaRepository.findByName(StringUtils.capitalize(firstname)));
//		return hello;
//	}
	
	@Operation(summary = "Get detail by status", description = "Get detail of a person by their status")
	@RequestMapping(value = "/getByStatus", method = RequestMethod.GET)
	public List<Hello> getDataByStatus(@RequestParam(name="status") boolean status) {
		List<Hello> list = new ArrayList<Hello>();
		list = helloSpringDataJpaRepository.findByStatus(status);
		return list;
	}
	
	@RequestMapping(value= "/getByDesignation", method = RequestMethod.GET)
	public List<Hello> getDataByDesignation(@RequestParam(name="designation") String designation){
		List<Hello> list = new ArrayList<Hello>();
		list = helloSpringDataJpaRepository.findByDesignation(StringUtils.capitalize(designation));
		return list;
	}
	
	@RequestMapping(value= "/getByDesignationAndStatus", method = RequestMethod.GET)
	public List<Hello> getDataByDesignationAndStatus(@RequestParam(name="designation") String designation, @RequestParam(name="status") boolean status){
		List<Hello> list = new ArrayList<Hello>();
		list = helloSpringDataJpaRepository.findByDesignationAndStatus(StringUtils.capitalize(designation), status);
		return list;
	}

	@RequestMapping(value = "/getByName", method = RequestMethod.GET)
	public List<Hello> getByNameAndDesignation(@RequestParam(name="name") String name) {
		return helloSpringDataJpaRepository.findByNameAndDesignation(name);
	}

}
