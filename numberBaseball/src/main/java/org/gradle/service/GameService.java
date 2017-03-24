package org.gradle.service;

import java.util.stream.IntStream;

import org.gradle.common.VerdictEnum;
import org.gradle.domain.Member;
import org.gradle.domain.Player;
import org.gradle.domain.Referee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	private static final Logger log = LoggerFactory.getLogger(GameService.class);
	
	private Player[] players;
	private int numberSize;
	
	/**
	 * 한명 이상이 게임할 때 만든다.
	 * 
	 * @param numberSize 게임에 사용될 숫자의 수
	 * @param peopleSize 게임에 참여할 사람의 수
	 */
	public void makeGame(int numberSize, int peopleSize){
		players = new Player[peopleSize];
		IntStream.range(0, peopleSize).forEach(i->players[i] = new Referee(numberSize));
		this.numberSize = numberSize;
	}
	
	/**
	 * 한명 이상이 게임할 때 만든다.
	 * 숫자를 유저가 직접 정한다.
	 * 
	 * @param numberSize 게임에 사용될 숫자의 수
	 * @param peopleSize 게임에 참여할 사람의 수
	 */
	public void makeGameAndMakeNumber(int numberSize, int peopleSize){
		players = new Player[peopleSize];
		IntStream.range(0, peopleSize).forEach(i->players[i] = new Member(numberSize));
		this.numberSize = numberSize;
	}
	
	public boolean setMakeNumber(int playerNum, String number){
		Member member;
		try {
			member = (Member) players[playerNum - 1];
		} catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return member.setNumber(number);
	}
	
	public String inputNum(int playerNumber, String num){
		Player player = players[playerNumber];
		String[] numbersStr = num.split(" ");
		if(inputNumberConfirm(player, numbersStr)){
			return "";
		}
		String confirm = player.confirmAnswer(numbersStr);
		if(confirm.startsWith(numberSize + VerdictEnum.STRIKE.getValue())){
			return VerdictEnum.SUCCESS.getValue();
		}
		return confirm;
	}
	
	public String getAnswer(int playerNumber){
		return players[playerNumber].showAnswer();
	}
	
	public boolean IsGiveUpPlayer(int playerNumber){
		return players[playerNumber].isGiveUp();
	}
	
	public void setGiveUp(int playerNumber){
		players[playerNumber].setGiveUp(true);
	}
	
	public int nextPlayer(int playerNumber){
		int next = playerNumber;
		int count = 0;
		int playerSize = players.length;
		while(count<=playerSize){
			next++;
			if(next >= playerSize){
				next = 0;
			}
			if(!players[next].isGiveUp()){
				break;
			}
			count++;
		}
		return next + 1;
	}
	
	/**
	 * 두명 미만이면 게임이 끝난다.
	 * @return 게임이 끝나면 true 아니면 false
	 */
	public boolean gameOver(){
		int count = 0;
		for(Player player : players){
			if(!player.isGiveUp()){
				count++;
				if(count >= 2){
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean inputNumberConfirm(Player player, String[] numbersStr){
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
