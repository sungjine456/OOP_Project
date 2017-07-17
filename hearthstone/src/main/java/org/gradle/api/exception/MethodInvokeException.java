package org.gradle.api.exception;

public class MethodInvokeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MethodInvokeException(String message){
		super(message);
	}
}
