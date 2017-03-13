package org.gradle.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.gradle.common.VerdictEnum;

public class Member implements Player {
	private final int NUMBERS_BEFORE_SELECTION = 10;
	
	private List<Integer> numberList = new LinkedList<Integer>();
	private int numberSize;
	
	public Member(int numberSize){
		this.numberSize = numberSize;
	}
	
	@Override
	public String confirmAnswer(String[] numbersStr){
		int len = numbersStr.length;
		int s = 0;
		int f = 0;
		for(int i = 0; i < len; i++){
			if(Integer.parseInt(numbersStr[i]) == numberList.get(i)){
				s += 1;
			}
			for(int j = 0; j < len; j++){
				if(Integer.parseInt(numbersStr[i]) == numberList.get(j)){
					f += 1;
				}
			}
		}
		return s + VerdictEnum.STRIKE.getValue() + " " + (f - s) + VerdictEnum.BALL.getValue();
	}
	
	@Override
	public String showAnswer(){
		StringBuilder sb = new StringBuilder();
		int size = numberList.size();
		IntStream.range(0, size).forEach(i->sb.append(numberList.get(i)));
		return sb.toString();
	}
	
	public boolean setNumber(String number){
		String[] str = number.split("");
		if(str.length != numberSize){
			return false;
		}
		if(parseNumbers(str)){
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
