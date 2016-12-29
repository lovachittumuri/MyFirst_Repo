package com.lova.annotation.example;

public class Service {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void showMesssage() {

		System.out.println("Hello Here is the message : " + message);
	}

}
