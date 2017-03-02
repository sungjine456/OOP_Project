package org.gradle.service;

import java.util.Scanner;
import java.util.stream.IntStream;

import org.gradle.common.NumberSize;
import org.gradle.domain.Member;
import org.gradle.domain.Player;
import org.gradle.domain.Referee;
import org.gradle.domain.VerdictEnum;

public class Game {
	private static int numberSize;
	private static Scanner sc = new Scanner(System.in);
	public void start(){
		System.out.println("Start Number BaseBall Game");
		boolean finish = true;
		while(finish){
			System.out.println("게임을 선택해 주세요.\n1. 1인용\n2. 2인용\n3. 3인 이상\n0. 게임 종료(1, 2를 제외한 모든 숫자)");
			int i = changeStringIsNumber(sc.next());
			switch (i) {
				case 1:
					playingOnePerson();
					break;
				case 2:
					playingNotOnePerson(2);
					break;
				case 3:
					System.out.println("사람 수를 정해주세요. (1이하의 수입력시 1인으로 시작)");
					int numberOfPeople = changeStringIsNumber(sc.next());
					if(numberOfPeople > 1){
						playingNotOnePerson(numberOfPeople);
					} else {
						playingOnePerson();
					}
					break;
				default:
					finish = false;
					break;
			}
		}
	}
	
	private void setNumber(){
		System.out.println("숫자의 수를 정해주세요. ex) "+NumberSize.MIN_NUMBER_SIZE+"이상 "+NumberSize.MAX_NUMBER_SIZE+"이하의 수를 입력해주세요");
		numberSize = changeStringIsNumber(sc.next());
		if(numberSize < NumberSize.MIN_NUMBER_SIZE || numberSize > NumberSize.MAX_NUMBER_SIZE){
			System.out.print("다시 ");
			setNumber();
		}
	}
	
	private void playingNotOnePerson(int numberOfPeople){
		setNumber();
		System.out.println("게임 시작!!");
		Player[] players = new Player[numberOfPeople];
		IntStream.range(0, numberOfPeople).forEach(i->players[i]=new Member(numberSize));
		int count = 0;
		boolean[] win = new boolean[numberOfPeople];
		while(count == 0){
			for(int i = 1; i <= numberOfPeople; i++){
				System.out.println(i + "인 숫자를 입력해주세요. ex) 1234");
				String[] numbersStr = sc.next().split("");
				if(inputNumberConfirm(players[i - 1], numbersStr, i)){
					break;
				}
				if(players[i - 1].confirmAnswer(numbersStr).equals(numberSize + VerdictEnum.STRIKE.getValue() + " 0" + VerdictEnum.BALL.getValue())){
					System.out.println(i + "인 성공 !!");
					count += 1;
					win[i - 1] = true;
				}
			}
		}
		System.out.println(count!=numberOfPeople?resultAnnouncement(win):"무승부!!");
	}
	
	private void playingOnePerson(){
		setNumber();
		System.out.println("게임 시작!!");
		Player player = new Referee(numberSize);
		
		while(true){
			System.out.println("숫자를 입력해주세요. ex) 1234");
			String[] numbersStr = sc.next().split("");
			if(inputNumberConfirm(player, numbersStr, 0)){
				continue;
			}
			if(player.confirmAnswer(numbersStr).equals(numberSize + VerdictEnum.STRIKE.getValue() + " 0" + VerdictEnum.BALL.getValue())){
				System.out.println("성공 !!");
				break;
			}
		}
	}
	
	private boolean inputNumberConfirm(Player player, String[] numbersStr, int i){
		if("a".equals(numbersStr[0])){
			System.out.println(i==0?"answer : " + player.showAnswer()
									:"memeber" + i + " answer : " + player.showAnswer());
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
	
	private int changeStringIsNumber(String str){
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException e) {
			System.out.println("다시 입력해 주세요.");
			return changeStringIsNumber(sc.next());
		}
	}
	
	private String resultAnnouncement(boolean[] win){
		StringBuilder sb = new StringBuilder();
		int winLength = win.length;
		if(win[0]){
			sb.append("1인");
		}
		IntStream.range(1, winLength).filter(i->win[i]).forEach(i->sb.append(", " + (i + 1) + "인"));
 		sb.append(" 승리!!");
		return sb.toString();
	}
}
