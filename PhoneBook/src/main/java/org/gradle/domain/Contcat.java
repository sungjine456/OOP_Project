package org.gradle.domain;

import org.gradle.common.StringUtils;
import org.gradle.common.Utils;
import org.gradle.exception.FailNumberException;

public final class Contcat implements Comparable<Contcat>{
	private final String name;
	private final String number;
	
	public Contcat(String name, String number){
		if(StringUtils.isEmpty(name)||StringUtils.isEmpty(number)){
			throw new NullPointerException();
		}
		if(!Utils.numberCheck(number)){
			throw new FailNumberException();
		}
		this.name = name;
		this.number = number;
	}
	
	public boolean isExistWord(String word){
		return name.contains(word)||number.contains(word);
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + number.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object o){
		if(o==this) return true;
		if(!(o instanceof Contcat)) return false;
		Contcat contcat = (Contcat)o;
		return contcat.getName().equals(name) && contcat.getNumber().equals(number);
	}
	@Override
	public String toString(){
		return "name : " + name + ", number : " + number;
	}

	@Override
	public int compareTo(Contcat o) {
		int len1 = name.length();
        int len2 = o.getName().length();
        int lim = Math.min(len1, len2);
        char v1[] = name.toCharArray();
        char v2[] = o.getName().toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                if(isKorean(c1)&&isKorean(c2)){
                	return c1-c2;
                } else if(isKorean(c1)&&!isKorean(c2)){
                	return -1;
                } else if(!isKorean(c1)&&isKorean(c2)){
                	return 1;
                } else {
                	if(isEnglish(c1)&&isEnglish(c2)){
                		return c1-c2;
                	} else if(isEnglish(c1)&&!isEnglish(c2)){
                		return -1;
                	} else if(!isEnglish(c1)&&isEnglish(c2)){
                		return 1;
                	} else {
                		return c1-c2;
                	}
                }
            }
            k++;
        }
        return len1 - len2;
	}
	
	private boolean isKorean(char ch){
		return ch>='가' && ch<='힣';
	}
	private boolean isEnglish(char ch){
		return (ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z');
	}
}
