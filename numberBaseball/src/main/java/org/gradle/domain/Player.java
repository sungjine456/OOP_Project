package org.gradle.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.gradle.common.VerdictEnum;

public class Player {
	protected final int NUMBERS_BEFORE_SELECTION = 10;
	
	protected List<Integer> numberList = new LinkedList<Integer>();
	
	public String confirmAnswer(String[] numbersStr){
		int len = numbersStr.length;
		byte strike = (byte) IntStream.range(0, len).filter(i -> Integer.parseInt(numbersStr[i])==numberList.get(i)).count();
		byte ball = (byte) Arrays.stream(numbersStr).mapToLong(i->
							numberList.stream().filter(j-> Integer.parseInt(i) == j).count()
						).sum();
		return strike + VerdictEnum.STRIKE.getValue() + " " + (ball - strike) + VerdictEnum.BALL.getValue();
	}
	public String showAnswer(){
		StringBuilder sb = new StringBuilder();
		int size = numberList.size();
		IntStream.range(0, size).forEach(i->sb.append(numberList.get(i) + " "));
		return sb.toString();
	}
}
