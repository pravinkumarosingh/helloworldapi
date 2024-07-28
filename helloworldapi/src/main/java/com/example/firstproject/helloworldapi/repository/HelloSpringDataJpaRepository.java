package com.example.firstproject.helloworldapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstproject.helloworldapi.model.Hello;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HelloSpringDataJpaRepository extends JpaRepository<Hello, Integer>{
	Hello findByName(String name);

	Hello findById(int id);

	List<Hello> findByStatus(boolean status);

	List<Hello> findByDesignation(String designation);

	List<Hello> findByDesignationAndStatus(String capitalize, boolean status);


	@Query(value = "select * from persons where name = :name", nativeQuery = true)
	List<Hello> findByNameAndDesignation(@Param("name") String name);
	
}
