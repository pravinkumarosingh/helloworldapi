package com.example.firstproject.helloworldapi.service;

import com.example.firstproject.helloworldapi.model.Hello;
import com.example.firstproject.helloworldapi.repository.HelloSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Autowired
    public HelloSpringDataJpaRepository helloSpringDataJpaRepository;

    public Hello saveHello(Hello hello){
        return helloSpringDataJpaRepository.save(hello);
    }

}
