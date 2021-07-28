package com.pgatc.api.rest.exception;

public class AircraftAlreadyEnqueuedException extends RuntimeException{

	private static final long serialVersionUID = -8851946900460234829L;

	public AircraftAlreadyEnqueuedException (String message) {
		super(message);
	}
}
