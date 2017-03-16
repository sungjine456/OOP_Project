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
	
	private List<Integer> numberList = new LinkedList<Integer>();
	private int numberSize;
	
	public Referee(int numberSize){
		this.numberSize = numberSize;
		setNumberList();
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
		IntStream.range(0, size).forEach(i->sb.append(numberList.get(i) + " "));
		return sb.toString();
	}
	
	private void setNumberList(){
		IntStream.range(0, NUMBERS_BEFORE_SELECTION).forEach(i->numberList.add(i));
		shuffle();
	}
	
	private void shuffle(){
		Random random = new Random();
		IntStream.range(0, NUMBERS_BEFORE_SELECTION - numberSize)
				.forEach(n -> numberList.remove(random.nextInt(numberList.size())));
		do{
			Collections.shuffle(numberList);
		} while(numberList.get(0) == 0);
	}
}
