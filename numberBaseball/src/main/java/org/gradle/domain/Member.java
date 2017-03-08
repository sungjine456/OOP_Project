package org.gradle.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.gradle.common.VerdictEnum;

public class Member implements Player {
	private List<Integer> numberList = new LinkedList<Integer>();
	
	public Member(int numberSize){
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
		return s + VerdictEnum.STRIKE.getValue() + " " + (f - s) + VerdictEnum.BALL.getValue();
	}
	
	@Override
	public String showAnswer(){
		StringBuilder sb = new StringBuilder();
		int size = numberList.size();
		IntStream.range(0, size).forEach(i->sb.append(numberList.get(i)));
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
