package org.gradle.domain;

import java.util.Scanner;

public class Game {
	public void start(){
		System.out.println("Start Number BaseBall Game");
		Scanner sc = new Scanner(System.in);
		
		while(true){
			boolean finish = false;
			System.out.println("������ ������ �ּ���.\n1. 1�ο�\n0. ���� ����(1, 2�� ������ ��� ����)");
			int i = changeStringIsNumber(sc, sc.next());
			switch (i) {
				case 1:
					playingOnePerson(sc);
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
	
	private void playingOnePerson(Scanner sc){
		System.out.println("������ ���� �����ּ���");
		int numberSize = changeStringIsNumber(sc, sc.next());
		Referee referee = new Referee(numberSize);
		
		while(true){
			System.out.println("���ڸ� �Է����ּ���. ex) 1234");
			String[] numbersStr = sc.next().split("");
			if("a".equals(numbersStr[0])){
				System.out.println(referee.showAnswer(numberSize));
				continue;
			}
			if(confirmInputIsNotNumber(numberSize, numbersStr)){
				System.out.print("�ٽ� ");
			}
			System.out.println(referee.confirmAnswer(numbersStr));
			if(referee.confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
				System.out.println("���� !!");
				break;
			}
		}
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
			return changeStringIsNumber(sc, sc.nextLine());
		}
	}
}
