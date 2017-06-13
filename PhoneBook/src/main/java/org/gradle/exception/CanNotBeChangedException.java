package org.gradle.exception;

public class CanNotBeChangedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CanNotBeChangedException(String name){
		super(name + "(은)는 변경할 수 없는 값입니다.");
	}
}
