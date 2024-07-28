package com.example.firstproject.helloworldapi.controller;

import com.example.firstproject.helloworldapi.CurrencyServiceConfiguration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Currency Controller API", description = "These API helps in converting the currency")
public class CurrencyServiceController {
	
	@Autowired
	private CurrencyServiceConfiguration configuration;

	@Operation(summary = "Currency Configuration", description = "Here configure the currency their current value")
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration getDetails() {
		return configuration;
	}
}
