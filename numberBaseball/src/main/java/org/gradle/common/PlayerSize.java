package org.gradle.common;

public enum PlayerSize {
	MIN_PLAYER_SIZE(2),
	MAX_PLAYER_SIZE(4);
	
	private int size;
	
	PlayerSize(int size){
		this.size = size;
	}
	
	public String getKey(){
		return name();
	}
	public int getSize(){
		return size;
	}
}
