package org.gradle.domain;

import java.util.Scanner;

public class Game {
	public void start(){
		System.out.println("Start Number BaseBall Game");
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���� �����ּ���");
		int numberSize = sc.nextInt();
		Referee referee = new Referee(numberSize);
		
		playing(sc, numberSize, referee);
	}
	
	private void playing(Scanner sc, int numberSize, Referee referee){
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
}
