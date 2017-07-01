package org.gradle.controller;

import java.util.Scanner;

import org.gradle.common.Utils;

public abstract class Controller {
	protected Scanner sc;
	
	public Controller(Scanner sc){
		this.sc = sc;
	}
	
	protected void play(String message, int endNum){
		while(true){
			System.out.println(message);
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
	
	abstract public void searchMenu(int num);
}
