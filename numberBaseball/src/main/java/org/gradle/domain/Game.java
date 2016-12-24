package org.gradle.domain;

import java.util.Scanner;

public class Game {
	static int numberSize;
	public void start(){
		System.out.println("Start Number BaseBall Game");
		Scanner sc = new Scanner(System.in);
		
		while(true){
			boolean finish = false;
			System.out.println("게임을 선택해 주세요.\n1. 1인용\n2. 2인용\n0. 게임 종료(1, 2를 제외한 모든 숫자)");
			int i = changeStringIsNumber(sc, sc.next());
			switch (i) {
				case 1:
					playingOnePerson(sc);
					break;
				case 2:
					playingTwoPeople(sc);
					break;
				default:
					finish = true;
					break;
			}
			if(finish){
				break;
			}
		}
	}
	
	private void playingTwoPeople(Scanner sc){
		System.out.println("숫자의 수를 정해주세요");
		numberSize = changeStringIsNumber(sc, sc.next());
		Player[] players = {new Member(numberSize), new Member(numberSize)};
		int playersLength = players.length;
		int win = 0;
		while(win == 0){
			for(int i = 1; i <= playersLength; i++){
				System.out.println(i + "인 숫자를 입력해주세요. ex) 1234");
				String[] numbersStr = sc.next().split("");
				if(inputNumberConfirm(sc, players[i], numbersStr, i)){
					break;
				}
				if(players[i].confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
					System.out.println(i + "인 성공 !!");
					win += i;
				}
			}
			switch (win) {
			case 1:
				System.out.println("1인 승리!");
				break;
			case 2:
				System.out.println("2인 승리!");
				break;
			case 3:
				System.out.println("무승부");
				break;
			}
		}
	}
	
	private void playingOnePerson(Scanner sc){
		System.out.println("숫자의 수를 정해주세요");
		numberSize = changeStringIsNumber(sc, sc.next());
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
	}
	
	private boolean inputNumberConfirm(Scanner sc, Player player, String[] numbersStr, int i){
		if("a".equals(numbersStr[0])){
			System.out.println(i==0?"answer : " + player.showAnswer(numberSize)
									:"memeber" + i + " answer : " + player.showAnswer(numberSize));
			return true;
		}
		if(confirmInputIsNotNumber(numberSize, numbersStr)){
			System.out.print("다시 ");
			return true;
		}
		System.out.println(player.confirmAnswer(numbersStr));
		return false;
	}
	
	private boolean confirmInputIsNotNumber(int numberSize, String[] numbersStr){
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
}
