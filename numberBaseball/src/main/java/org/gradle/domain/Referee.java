package org.gradle.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Referee implements Player {
	private List<Integer> numberList = new LinkedList<>();
	
	public Referee(int numberSize){
		makeNumberList(numberSize);
		shuffle(numberSize);
	}
	
	@Override
	public String confirmAnswer(String[] numbersStr){
		int len = numbersStr.length;
		byte s = (byte)IntStream.range(0, len).filter(i -> Integer.parseInt(numbersStr[i])==numberList.get(i)).count();
		int f = 0;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(Integer.parseInt(numbersStr[i]) == numberList.get(j)){
					f += 1;
				}
			}
		}
		return s + "S " + (f - s) + "B";
	}
	
	@Override
	public String showAnswer(){
		StringBuilder sb = new StringBuilder();
		int size = numberList.size();
		IntStream.range(0, size).forEach(i->sb.append(numberList.get(i)+" "));
		return sb.toString();
	}
	
	private void makeNumberList(int numberSize){
		IntStream.range(0, 10).forEach(i->numberList.add(i));
	}
	
	private void shuffle(int numberSize){
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
