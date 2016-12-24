package org.gradle.domain;

import java.util.Scanner;

public class Game {
	static int numberSize;
	public void start(){
		System.out.println("Start Number BaseBall Game");
		Scanner sc = new Scanner(System.in);
		
		while(true){
			boolean finish = false;
			System.out.println("������ ������ �ּ���.\n1. 1�ο�\n2. 2�ο�\n0. ���� ����(1, 2�� ������ ��� ����)");
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
		System.out.println("������ ���� �����ּ���");
		numberSize = changeStringIsNumber(sc, sc.next());
		Player[] players = {new Member(numberSize), new Member(numberSize)};
		int playersLength = players.length;
		int win = 0;
		while(win == 0){
			for(int i = 1; i <= playersLength; i++){
				System.out.println(i + "�� ���ڸ� �Է����ּ���. ex) 1234");
				String[] numbersStr = sc.next().split("");
				if(inputNumberConfirm(sc, players[i], numbersStr, i)){
					break;
				}
				if(players[i].confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
					System.out.println(i + "�� ���� !!");
					win += i;
				}
			}
			switch (win) {
			case 1:
				System.out.println("1�� �¸�!");
				break;
			case 2:
				System.out.println("2�� �¸�!");
				break;
			case 3:
				System.out.println("���º�");
				break;
			}
		}
	}
	
	private void playingOnePerson(Scanner sc){
		System.out.println("������ ���� �����ּ���");
		numberSize = changeStringIsNumber(sc, sc.next());
		Player player = new Referee(numberSize);
		
		while(true){
			System.out.println("���ڸ� �Է����ּ���. ex) 1234");
			String[] numbersStr = sc.next().split("");
			if(inputNumberConfirm(sc, player, numbersStr, 0)){
				continue;
			}
			if(player.confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
				System.out.println("���� !!");
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
			System.out.print("�ٽ� ");
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
			System.out.println("�ٽ� �Է��� �ּ���.");
			return changeStringIsNumber(sc, sc.next());
		}
	}
}
