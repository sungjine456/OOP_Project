package org.gradle.dto;

import org.hibernate.validator.constraints.Length;

public class PlayerDto {
	@Length(min=4, max=10, message="아이디를 다시 입력해주세요.")
	private String id;
	@Length(min=4, max=10, message="비밀번호를 다시 입력해주세요.")
	private String password;
	
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
