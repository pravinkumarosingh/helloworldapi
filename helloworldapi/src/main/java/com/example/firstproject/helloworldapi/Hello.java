package com.example.firstproject.helloworldapi;

public class Hello {
	private int id;
	

	private String message;
	private String name;
	
	public Hello(int id, String message, String name) {
		super();
		this.id = id;
		this.message = message;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Hello [id=" + id + ", message=" + message + ", name=" + name + "]";
	}
}
