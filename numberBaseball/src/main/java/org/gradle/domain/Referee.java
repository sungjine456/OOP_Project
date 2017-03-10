package org.gradle.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.gradle.common.VerdictEnum;

public class Referee implements Player {
	private final int NUMBERS_BEFORE_SELECTION = 10;
	
	private List<Integer> numberList = new LinkedList<>();
	
	public Referee(int numberSize){
		setNumberList(numberSize);
	}
	
	@Override
	public String confirmAnswer(String[] numbersStr){
		int len = numbersStr.length;
		byte strike = (byte) IntStream.range(0, len).filter(i -> Integer.parseInt(numbersStr[i])==numberList.get(i)).count();
		byte ball = (byte) Arrays.stream(numbersStr).mapToLong(i->
							numberList.stream().filter(j-> Integer.parseInt(i) == j).count()
						).sum();
		return strike + VerdictEnum.STRIKE.getValue() + " " + (ball - strike) + VerdictEnum.BALL.getValue();
	}
	
	@Override
	public String showAnswer(){
		StringBuilder sb = new StringBuilder();
		
		int size = numberList.size();
		IntStream.range(0, size).forEach(i->sb.append(numberList.get(i)+" "));
		
		return sb.toString();
	}
	
	private void setNumberList(int numberSize){
		IntStream.range(0, NUMBERS_BEFORE_SELECTION).forEach(i->numberList.add(i));
		
		shuffle(numberSize);
	}
	
	private void shuffle(int numberSize){
		int i = NUMBERS_BEFORE_SELECTION;
		Random random = new Random();
		while(numberList.size() > numberSize){
			int index = (int)(random.nextInt(i--));
			numberList.remove(index);
		}
		do{
			Collections.shuffle(numberList);
		} while(numberList.get(0) == 0);
	}
}
