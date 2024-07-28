package com.example.firstproject.helloworldapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Hello {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Schema(description = "Designation of a person associated with it", example = "Java Developer")
	private String designation;
	
	private String name;
	
	private boolean status = false;
	
	public Hello() {
		
	}
	
	public Hello(Integer id,String designation, String name, boolean status) {
		super();
		this.id = id;
		this.designation = designation;
		this.name = name;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Hello [id=" + id + ", designation=" + designation + ", name=" + name + ", status=" + status + "]";
	}
	
}
