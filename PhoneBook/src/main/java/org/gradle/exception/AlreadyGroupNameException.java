package org.gradle.exception;

public class AlreadyGroupNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlreadyGroupNameException(){
		super("이미 등록된 그룹입니다.");
	}
}
