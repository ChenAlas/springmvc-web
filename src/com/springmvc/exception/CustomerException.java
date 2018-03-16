package com.springmvc.exception;

public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String expMessage;
	
	public CustomerException() {
		
	}
	
	public CustomerException(String expMessage) {
		this.expMessage = expMessage;
	}
	
	public String getExpMessage() {
		return this.expMessage;
	}
	
	public void setExpMessage(String expMessage) {
		this.expMessage = expMessage;
	}
}
