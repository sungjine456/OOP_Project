package org.gradle.domain;

import org.gradle.common.StringUtils;
import org.gradle.common.Utils;
import org.gradle.exception.FailNumberException;

public class Contcat {
	private String name;
	private String number;
	private boolean spam;
	
	public Contcat(String name, String number){
		if(StringUtils.isEmpty(name)||StringUtils.isEmpty(number)){
			throw new NullPointerException();
		}
		if(!Utils.numberCheck(number)){
			throw new FailNumberException();
		}
		this.name = name;
		this.number = number;
		spam = false;
	}
	
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public boolean isSpam() {
		return spam;
	}
}
