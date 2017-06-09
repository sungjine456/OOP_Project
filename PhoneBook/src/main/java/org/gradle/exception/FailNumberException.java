package org.gradle.exception;

public class FailNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FailNumberException(String wrongNumber){
		super(wrongNumber + "는 전화번호 형식에 맞지 않습니다.(ex-01[0|1|6-9]-0000-0000)");
	}
}
