package org.ismetg.movieapp.exception;

import lombok.Getter;

@Getter
public class DemoException extends RuntimeException{
	private ErrorType errorType;
	
	public DemoException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
	
	public DemoException(ErrorType errorType,String customMessage) {
		super(customMessage);
		this.errorType = errorType;
	}
}