package org.gradle.service;

import java.util.stream.IntStream;

import org.gradle.domain.Player;
import org.gradle.domain.Referee;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	private Player player;
	private int numberSize;
	public void makeGame(int numberSize){
		player = new Referee(numberSize);
		this.numberSize = numberSize;
	}
	public String inputNum(String num){
		String[] numbersStr = num.split("");
		if(inputNumberConfirm(player, numbersStr, 0)){
			return "";
		}
		if(player.confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
			return "성공!!!";
		}
		return player.confirmAnswer(numbersStr);
	}
	
	private boolean inputNumberConfirm(Player player, String[] numbersStr, int i){
		if("a".equals(numbersStr[0])){
			System.out.println(i==0?"answer : " + player.showAnswer(numberSize)
									:"memeber" + i + " answer : " + player.showAnswer(numberSize));
			return true;
		}
		if(confirmInputIsNotNumber(numbersStr)){
			System.out.print("다시 ");
			return true;
		}
		System.out.println(player.confirmAnswer(numbersStr));
		return false;
	}
	
	private boolean confirmInputIsNotNumber(String[] numbersStr){
		int len = numbersStr.length;
		if(numberSize != len){
			return true;
		}
		try {
			IntStream.range(0, len).forEach(i->Integer.parseInt(numbersStr[i]));
		} catch(NumberFormatException e) {
			return true;
		}
		return false;
	}
}
