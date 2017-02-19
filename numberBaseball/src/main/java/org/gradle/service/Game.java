package org.gradle.service;

import java.util.Scanner;

import org.gradle.domain.Member;
import org.gradle.domain.Player;
import org.gradle.domain.Referee;

public class Game {
	static int numberSize;
	static boolean start = false;
	public void start(){
		System.out.println("Start Number BaseBall Game");
		Scanner sc = new Scanner(System.in);
		boolean finish = true;
		while(finish){
			System.out.println("������ ������ �ּ���.\n1. 1�ο�\n2. 2�ο�\n3. 3�� �̻�\n0. ���� ����(1, 2�� ������ ��� ����)");
			int i = changeStringIsNumber(sc, sc.next());
			switch (i) {
				case 1:
					playingOnePerson(sc);
					break;
				case 2:
					playingNotOnePerson(sc, 2);
					break;
				case 3:
					System.out.println("��� ���� �����ּ���. (1������ ���Է½� 1������ ����)");
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
		System.out.println("������ ���� �����ּ���. ex) 3�̻� 9������ ���� �Է����ּ���");
		numberSize = changeStringIsNumber(sc, sc.next());
		if(numberSize < 3 || numberSize > 9){
			System.out.print("�ٽ� ");
			setNumber(sc);
		}
		if(!start){
			System.out.println("���� ����!!");
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
				System.out.println(i + "�� ���ڸ� �Է����ּ���. ex) 1234");
				String[] numbersStr = sc.next().split("");
				if(inputNumberConfirm(sc, players[i - 1], numbersStr, i)){
					break;
				}
				if(players[i - 1].confirmAnswer(numbersStr).equals(numberSize + "S 0F")){
					System.out.println(i + "�� ���� !!");
					count += 1;
					win[i - 1] = true;
				}
			}
		}
		start = false;
		System.out.println(count!=numberOfPeople?resultAnnouncement(win):"���º�!!");
	}
	
	private void playingOnePerson(Scanner sc){
		setNumber(sc);
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
		start = false;
	}
	
	private boolean inputNumberConfirm(Scanner sc, Player player, String[] numbersStr, int i){
		if("a".equals(numbersStr[0])){
			System.out.println(i==0?"answer : " + player.showAnswer(numberSize)
									:"memeber" + i + " answer : " + player.showAnswer(numberSize));
			return true;
		}
		if(confirmInputIsNotNumber(numbersStr)){
			System.out.print("�ٽ� ");
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
			System.out.println("�ٽ� �Է��� �ּ���.");
			return changeStringIsNumber(sc, sc.next());
		}
	}
	
	private String resultAnnouncement(boolean[] win){
		StringBuilder sb = new StringBuilder();
		int winLength = win.length;
		if(win[0]){
			sb.append("1��");
		}
		for(int i = 1; i < winLength; i++){
			if(win[i]){
				sb.append(", " + (i + 1) + "��");
			}
		}
		sb.append(" �¸�!!");
		return sb.toString();
	}
}
