package com.fk.interview.exception;

/**
 * 
 * @author shubham
 *
 */
public class InvalidQuestionException extends Exception {
	
	private String message;

	public InvalidQuestionException(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
