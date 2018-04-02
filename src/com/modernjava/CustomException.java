package com.modernjava;

public class CustomException extends Throwable {
	private static final long serialVersionUID = -1576030719669262987L;

	public CustomException() {
		super();
	}
	 
	public CustomException(String msg) {
		super(msg);
	}
	 
	@Override
	public String getMessage() {
		return "No value present in the Optional instance";
	}
}