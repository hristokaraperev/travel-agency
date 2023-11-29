package org.fmi.plovdiv.travelagency.exceptions;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
	public void handleNoSuchElementException() {
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(BadContactInformationException.class)
	public void handleBadContactInformationException() {
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
	public void handleDataIntegrityViolationException() {
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(BadDestinationInformationException.class)
	public void handleBadDestinationInformationException() {
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(BadLocationInformationException.class)
	public void handleBadLocationInformationException() {
		
	}
	
	
}
