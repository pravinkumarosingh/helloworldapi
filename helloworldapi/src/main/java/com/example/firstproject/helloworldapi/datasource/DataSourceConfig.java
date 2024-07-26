package com.example.firstproject.helloworldapi.datasource;

import javax.sql.DataSource;

import com.example.firstproject.helloworldapi.service.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
    @Value("${encrypted.database.password}")
    private String encryptedPassword;

    @Autowired
    private DecryptService decryptService;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(decryptService.decryptPassword(encryptedPassword));
        return dataSourceBuilder.build();
    }

}
