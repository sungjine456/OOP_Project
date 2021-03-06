package org.gradle.domain;

import org.gradle.common.StringUtils;
import org.gradle.common.Utils;
import org.gradle.exception.FailNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Contcat {
	private static final Logger log = LoggerFactory.getLogger(Contcat.class);
	
	private final String name;
	private final String number;
	
	public Contcat(String name, String number) throws FailNumberException {
		if(StringUtils.isEmpty(name)||StringUtils.isEmpty(number)){
			log.debug("이름과 전화번호 모두 작성되어야 합니다. 이름 : " + name + ", 전화번호 : " + number);
			throw new NullPointerException();
		}
		if(!Utils.numberCheck(number)){
			throw new FailNumberException(number);
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
}
