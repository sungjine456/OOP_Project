package org.gradle.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Referee implements Player {
	private List<Integer> numberList = new LinkedList<Integer>();
	
	public Referee(int numberSize){
		makeNumberList(numberSize);
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
		return s + "S " + (f - s) + "F";
	}
	
	@Override
	public String showAnswer(int len){
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, len).forEach(i->sb.append(numberList.get(i)));
		return sb.toString();
	}
	
	private void makeNumberList(int numberSize){
		IntStream.range(0, 10).forEach(i->numberList.add(i));
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
