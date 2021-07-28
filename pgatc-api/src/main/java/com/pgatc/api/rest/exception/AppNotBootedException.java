package com.pgatc.api.rest.exception;

public class AppNotBootedException extends RuntimeException{

	private static final long serialVersionUID = -8851946900460234829L;

	public AppNotBootedException (String message) {
		super(message);
	}
}
