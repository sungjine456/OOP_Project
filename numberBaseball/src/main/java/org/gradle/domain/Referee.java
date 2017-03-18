package org.gradle.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Referee extends Player {
	private List<Integer> numberList;
	private int numberSize;
	
	public Referee(int numberSize){
		numberList = super.numberList;
		this.numberSize = numberSize;
		setNumberList();
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
