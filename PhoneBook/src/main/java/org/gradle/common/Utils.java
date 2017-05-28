package org.gradle.common;

import java.util.regex.Pattern;

public class Utils {
	public static int changeStringIsNumber(String str){
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException e) {
			return -1;
		}
	}
	
	public static boolean numberCheck(String number){
		if(number == null) return false;
		
		return Pattern.matches("01(0|1|[6-9])-(\\d{3}|\\d{4})-\\d{4}", number);
	}
}
