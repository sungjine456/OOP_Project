package org.gradle.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Member {
	private List<Integer> numberList = new LinkedList<Integer>();
	
	public Member(int numberSize){
		makeNumberList(numberSize);
	}
	
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
		return s + "S " + (f - s) + "F";
	}
	
	public String showAnswer(int len){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++){
			sb.append(numberList.get(i));
		}
		return sb.toString();
	}
	
	private void makeNumberList(int numberSize){
		for(int i = 0; i < 10; i ++){
			numberList.add(i);
		}
		int i = 10;
		while(numberList.size() > numberSize){
			int index = (int)(Math.random() * i);
			numberList.remove(index);
			i--;
		}
		do{
			Collections.shuffle(numberList);
		} while(numberList.get(0) == 0);
	}
}
