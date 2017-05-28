package org.gradle.common;

public class StringUtils {
	public static boolean isEmpty(String str){
		if(str != null && !str.trim().isEmpty()){
			return false;
		}
		return true;
	}
	public static boolean isNotEmpty(String str){
		if(str != null && !str.trim().isEmpty()){
			return true;
		}
		return false;
	}
	public static boolean equals(String str1, String str2){
		if(str1 == null || str2 == null){
			return false;
		}
		return str1.equals(str2);
	}
	public static boolean equalsIgnore(String str1, String str2){
		if(str1 == null && str2 == null){
			return true;
		}
		if(str1 == null || str2 == null){
			return false;
		}
		str1 = str1.trim().toLowerCase();
		str2 = str2.trim().toLowerCase();
		return str1.equals(str2);
	}
}
