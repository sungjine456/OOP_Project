package org.gradle.domain;

public class Card {
	private String pattern;
	private String denomination;
	
	public Card(){
	}
	public Card(String pattern, String denominaton){
		this.pattern = pattern;
		this.denomination = denominaton;
	}

	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
}
