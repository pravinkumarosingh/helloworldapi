package com.example.firstproject.helloworldapi.service;


import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class DecryptService {

//	@Value("${secret-key}")
//	private String secretKey;

	@Autowired
	Environment environment;

	public String decryptPassword(String encryptedPassword){
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(environment.getProperty("secret-key"));
		return encryptor.decrypt(encryptedPassword);
	}

}
