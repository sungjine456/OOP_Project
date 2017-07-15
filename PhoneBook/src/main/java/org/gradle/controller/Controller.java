package org.gradle.controller;

import java.util.Scanner;

import org.gradle.common.Utils;

public abstract class Controller {
	protected Scanner sc;
	private final String END_MESSAGE = "나가기";
	
	protected Controller(Scanner sc){
		this.sc = sc;
	}
	
	protected void play(String[] menus){
		play(menus, END_MESSAGE);
	}

	protected void play(String[] menus, String endMessage){
		int endNum = menus.length + 1;
		while(true){
			for(int i = 0; i < menus.length; i++){
				System.out.println((i+1)+". " + menus[i]);
			}
			System.out.println(endNum + ". " + endMessage);
			int n = Utils.changeStringIsNumber(sc.next());
			if(n == endNum){
				break;
			}
			if(n == -1 || n > endNum){
				System.out.println("다시 입력하세요.");
				continue;
			}
			searchMenu(n);
		}
	}
	
	abstract protected void searchMenu(int num);
}
