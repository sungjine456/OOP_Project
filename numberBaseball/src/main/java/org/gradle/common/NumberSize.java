package org.gradle.common;

public enum NumberSize {
	MAX_NUMBER_SIZE(6),
	MIN_NUMBER_SIZE(3);
	
	private int size;
	
	NumberSize(int size){
		this.size = size;
	}
	
	public String getKey(){
		return name();
	}
	public int getSize(){
		return size;
	}
}
