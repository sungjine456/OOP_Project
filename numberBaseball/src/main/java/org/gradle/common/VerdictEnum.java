package org.gradle.common;

public enum VerdictEnum {
	STRIKE("S"),
	BALL("B"),
	SUCCESS("성공!!!");
	
	private String value;
	
	VerdictEnum(String value){
		this.value = value;
	}
	
	public String getKey(){
		return name();
	}
	public String getValue(){
		return value;
	}
}
