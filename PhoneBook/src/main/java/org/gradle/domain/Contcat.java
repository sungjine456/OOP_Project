package org.gradle.domain;

public class Contcat {
	private String name;
	private String number;
	private boolean spam;
	
	public Contcat(String name, String number){
		this.name = name;
		this.number = number;
		spam = false;
	}
	
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public boolean isSpam() {
		return spam;
	}
}
