package org.gradle.common;

import java.util.Scanner;

public class Utils {
	static final Scanner sc = new Scanner(System.in);
	
	public static Scanner getScanner(){
		return sc;
	}
	
	public static int changeStringIsNumber(String str){
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException e) {
			return -1;
		}
	}
}
