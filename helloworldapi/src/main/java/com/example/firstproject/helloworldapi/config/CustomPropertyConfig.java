package com.example.firstproject.helloworldapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:custom.properties")
})
public class CustomPropertyConfig {
}
