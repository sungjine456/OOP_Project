package org.gradle.service;

import java.util.Scanner;

import org.gradle.domain.Member;
import org.gradle.domain.Player;
import org.gradle.domain.Referee;

public class Game {
	private static final int MAX_NUMBER_SIZE = 9;
	private static final int MIN_NUMBER_SIZE = 3;
	private static int numberSize;
	private static boolean start = false;
	public void start(){
		System.out.println("Start Number BaseBall Game");
		Scanner sc = new Scanner(System.in);
		boolean finish = true;
		while(finish){
			System.out.println("게임을 선택해 주세요.\n1. 1인용\n2. 2인용\n3. 3인 이상\n0. 게임 종료(1, 2를 제외한 모든 숫자)");
			int i = changeStringIsNumber(sc, sc.next());
			switch (i) {
				case 1:
					playingOnePerson(sc);
					break;
				case 2:
					playingNotOnePerson(sc, 2);
					break;
				case 3:
					System.out.println("사람 수를 정해주세요. (1이하의 수입력시 1인으로 시작)");
					int numberOfPeople = changeStringIsNumber(sc, sc.next());
					if(numberOfPeople > 1){
						playingNotOnePerson(sc, numberOfPeople);
					} else {
						playingOnePerson(sc);
					}
					break;
				default:
					finish = false;
					break;
			}
		}
	}
	
	private void setNumber(Scanner sc){
		System.out.println("숫자의 수를 정해주세요. ex) "+MIN_NUMBER_SIZE+"이상 "+MAX_NUMBER_SIZE+"이하의 수를 입력해주세요");
		numberSize = changeStringIsNumber(sc, sc.next());
		if(numberSize < MIN_NUMBER_SIZE || numberSize > MAX_NUMBER_SIZE){
			System.out.print("다시 ");
			setNumber(sc);
		}
		if(!start){
			System.out.println("게임 시작!!");
			start = true;
		}
	}
	
	private void playingNotOnePerson(Scanner sc, int numberOfPeople){
		setNumber(sc);
		Player[] players = new Player[numberOfPeople];
		for(int i = 0; i < numberOfPeople; i++){
			players[i] = new Member(numberSize);
		}
		int count = 0;
		boolean[] win = new boolean[numberOfPeople];
		while(count == 0){
			for(int i = 1; i <= numberOfPeople; i++){
				System.out.println(i + "인 숫자를 입력해주세요. ex) 1234");
				String[] numbersStr = sc.next().split("");
				if(inputNumberConfirm(sc, players[i - 1], numbersStr, i)){
					break;
				}
				if(players[i - 1].confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
					System.out.println(i + "인 성공 !!");
					count += 1;
					win[i - 1] = true;
				}
			}
		}
		start = false;
		System.out.println(count!=numberOfPeople?resultAnnouncement(win):"무승부!!");
	}
	
	private void playingOnePerson(Scanner sc){
		setNumber(sc);
		Player player = new Referee(numberSize);
		
		while(true){
			System.out.println("숫자를 입력해주세요. ex) 1234");
			String[] numbersStr = sc.next().split("");
			if(inputNumberConfirm(sc, player, numbersStr, 0)){
				continue;
			}
			if(player.confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
				System.out.println("성공 !!");
				break;
			}
		}
		start = false;
	}
	
	private boolean inputNumberConfirm(Scanner sc, Player player, String[] numbersStr, int i){
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
		for(int i = 0; i < len; i++){
			try {
				Integer.parseInt(numbersStr[i]);
			} catch(NumberFormatException e) {
				return true;
			}
		}
		return false;
	}
	
	private int changeStringIsNumber(Scanner sc, String str){
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException e) {
			System.out.println("다시 입력해 주세요.");
			return changeStringIsNumber(sc, sc.next());
		}
	}
	
	private String resultAnnouncement(boolean[] win){
		StringBuilder sb = new StringBuilder();
		int winLength = win.length;
		if(win[0]){
			sb.append("1인");
		}
		for(int i = 1; i < winLength; i++){
			if(win[i]){
				sb.append(", " + (i + 1) + "인");
			}
		}
		sb.append(" 승리!!");
		return sb.toString();
	}
}
