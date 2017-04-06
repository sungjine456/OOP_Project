package org.gradle.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class PlayerDto {
	@NotEmpty
	private String id;
	@NotEmpty
	private String password;
	
	public PlayerDto(){
	}
	public PlayerDto(String id, String password){
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
