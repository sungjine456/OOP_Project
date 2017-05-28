package org.gradle.exception;

public class FailNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FailNumberException(){
		super("전화번호 형식에 맞지 않습니다.");
	}
}
