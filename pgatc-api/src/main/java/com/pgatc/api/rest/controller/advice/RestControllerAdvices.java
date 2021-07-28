package com.pgatc.api.rest.controller.advice;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.pgatc.api.rest.exception.AircraftAlreadyEnqueuedException;
import com.pgatc.api.rest.exception.AppNotBootedException;
import com.pgatc.api.rest.exception.NoAircraftInQueueException;

@RestControllerAdvice
class RestControllerAdvices {

	@RestControllerAdvice
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class AppNotBootedAdvice {
	  @ExceptionHandler(AppNotBootedException.class)
	  String employeeNotFoundHandler(AppNotBootedException ex) {
	    return ex.getMessage();
	  }
	}
	
	@RestControllerAdvice
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class MethodArgumentTypeAdvice {
	  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
	  String employeeNotFoundHandler(MethodArgumentTypeMismatchException ex) {
	    return ex.getMessage();
	  }
	}
	
	@RestControllerAdvice
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class MissingPathVariableExceptionAdvice {
		@ExceptionHandler(MissingPathVariableException.class)
		String missingPathVariableException(MissingPathVariableException ex) {
			return ex.getMessage();
		}
	}
	
	@RestControllerAdvice
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class AircraftAlreadyEnqueuedExceptionAdvice {
		@ExceptionHandler(AircraftAlreadyEnqueuedException.class)
		String aircraftAlreadyEnqueuedException(AircraftAlreadyEnqueuedException ex) {
			return ex.getMessage();
		}
	}
	
	@RestControllerAdvice
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class NumberFormatExceptionAdvice {
		@ExceptionHandler(NumberFormatException.class)
		String numberFormatException(NumberFormatException ex) {
			return ex.getMessage();
		}
	}
	
	@RestControllerAdvice
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class NoAircraftInQueueAdvice {
		@ExceptionHandler(NoAircraftInQueueException.class)
		String noAircraftInQueueException(NoAircraftInQueueException ex) {
			return ex.getMessage();
		}
	}
	
	@RestControllerAdvice
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class PropertyValueExceptionAdvice {
		@ExceptionHandler(PropertyValueException.class)
		String propertyValueException(PropertyValueException ex) {
			return ex.getMessage();
		}
	}
	
}