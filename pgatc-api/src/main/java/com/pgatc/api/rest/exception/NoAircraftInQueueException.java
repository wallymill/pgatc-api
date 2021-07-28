package com.pgatc.api.rest.exception;

public class NoAircraftInQueueException extends RuntimeException{

	private static final long serialVersionUID = -7472366081181750684L;
	
	public NoAircraftInQueueException (String message) {
		super(message);
	}

}
