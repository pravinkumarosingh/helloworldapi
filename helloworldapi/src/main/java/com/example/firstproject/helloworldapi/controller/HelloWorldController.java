package com.example.firstproject.helloworldapi.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.firstproject.helloworldapi.service.HelloWorldService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import com.example.firstproject.helloworldapi.model.Hello;
import com.example.firstproject.helloworldapi.springdatajparepository.HelloSpringDataJpaRepository;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@Component
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
	public List<Hello> getData(){
		return helloSpringDataJpaRepository.findAll();
	}
	
	@RequestMapping(value = "/name", method = RequestMethod.POST)
	public void setData(@RequestBody Hello hello) {
		LOGGER.info("Hello -> {}", hello);
		helloWorldService.saveHello(hello);
	}
	
	@RequestMapping(value= "/getById", method = RequestMethod.GET)
	public Optional<Hello> getDataById(@RequestParam(name="id") int id) {
		Optional<Hello> hello =  helloSpringDataJpaRepository.findById(id);
		return hello;
	}
	
	@RequestMapping(value= "/getByName", method = RequestMethod.GET)
	public Optional<Hello> getDataByName(@RequestParam(name="firstname") String firstname) {
		Optional<Hello> hello = Optional.ofNullable(new Hello());
		hello =  Optional.ofNullable(helloSpringDataJpaRepository.findByName(StringUtils.capitalize(firstname)));
		return hello;
	}
	

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

}
