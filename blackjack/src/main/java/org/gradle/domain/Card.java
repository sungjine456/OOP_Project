package org.gradle.domain;

public class Card {
	private String pattern;
	private String denomination;
	private int point;
	
	public Card(String pattern, int index){
		this.pattern = pattern;
		this.denomination = numberToDenomination(index);
		this.point = numberToPoint(index);
	}
	
	private String numberToDenomination(int cardNumber){
		String denomination;
		if(cardNumber == 1){
			denomination = "A";
		} else if(cardNumber == 11){
			denomination = "J";
		} else if(cardNumber == 12){
			denomination = "Q";
		} else if(cardNumber == 13){
			denomination = "K";
		} else {
			denomination = String.valueOf(cardNumber);
		}
		
		return denomination;
	}
	
	private int numberToPoint(int number){
		if(number > 10){
			number = 10;
		}
		
		return number;
	}

	public String getPattern() {
		return pattern;
	}
	public String getDenomination() {
		return denomination;
	}
	public int getPoint(){
		return point;
	}
	
	public String toString(){
		return "pattern : " + pattern + ", denomination : " + denomination;
	}
}
