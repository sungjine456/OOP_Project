package org.gradle.service;

import java.util.stream.IntStream;

import org.gradle.domain.Player;
import org.gradle.domain.Referee;
import org.gradle.domain.VerdictEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	private static final Logger log = LoggerFactory.getLogger(GameService.class);
	
	private Player[] players;
	private int numberSize;
	
	public void makePersonGame(int numberSize){
		players = new Player[1];
		players[0] = new Referee(numberSize);
		this.numberSize = numberSize;
	}
	public void makePeopleGame(int numberSize, int peopleSize){
		players = new Player[peopleSize];
		IntStream.range(0, peopleSize).forEach(i->players[i] = new Referee(numberSize));
		this.numberSize = numberSize;
	}
	
	public String inputNum(int playerNumber, String num){
		Player player = players[playerNumber];
		String[] numbersStr = num.split(" ");
		if(inputNumberConfirm(player, numbersStr, 0)){
			return "";
		}
		if(player.confirmAnswer(numbersStr).equals(numberSize + VerdictEnum.STRIKE.getValue() + " 0" + VerdictEnum.BALL.getValue())){
			return "성공!!!";
		}
		return player.confirmAnswer(numbersStr);
	}
	
	public String getAnswer(int playerNumber){
		return players[playerNumber].showAnswer();
	}
	
	private boolean inputNumberConfirm(Player player, String[] numbersStr, int i){
		if(confirmInputIsNotNumber(numbersStr)){
			log.debug(" 정확한 숫자를 입력해 주세요. ");
			return true;
		}
		log.debug(player.confirmAnswer(numbersStr));
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
