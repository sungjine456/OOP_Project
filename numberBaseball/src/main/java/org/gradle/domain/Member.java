package org.gradle.domain;

import java.util.List;

public class Member extends Player {
	private List<Integer> numberList;
	private int numberSize;
	
	public Member(int numberSize){
		numberList = super.numberList;
		this.numberSize = numberSize;
	}
	
	public boolean setNumber(String number){
		String[] str = number.split("");
		if(str.length != numberSize){
			return false;
		}
		if(!parseNumbers(str)){
			return false;
		}
		return notSameNumber();
	}
	
	private boolean notSameNumber(){
		boolean[] sameCheckArr = new boolean[NUMBERS_BEFORE_SELECTION];
		for(int number : numberList){
			if(sameCheckArr[number]){
				return false;
			}
			sameCheckArr[number] = true;
		}
		return true;
	}
	
	private boolean parseNumbers(String[] numbers){
		try {
			for(String number : numbers){
				numberList.add(Integer.parseInt(number));
			}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
}
