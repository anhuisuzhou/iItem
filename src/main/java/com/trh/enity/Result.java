package com.trh.enity;

public class Result<T> {
	String code;
	String message;
	
	T other;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getOther() {
		return other;
	}

	public void setOther(T other) {
		this.other = other;
	}
	
	
	
	
	

}
