package com.johnsunday.aop.main;

public class Customer {
	
	private String name;
	private String type;
	
	public Customer() {
	}
	public Customer(String name, String type) {
		this.name = name;
		this.type = type;
	}
	// Getters and Setters.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", type=" + type + "]";
	}
}
