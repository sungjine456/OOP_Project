package org.gradle.domain;

public class Card {
	private String pattern;
	private String denomination;
	
	public Card(String pattern, String denominaton){
		this.pattern = pattern;
		this.denomination = denominaton;
	}

	public String getPattern() {
		return pattern;
	}
	public String getDenomination() {
		return denomination;
	}
	
	public String toString(){
		return "pattern : " + pattern + ", denomination : " + denomination;
	}
}
