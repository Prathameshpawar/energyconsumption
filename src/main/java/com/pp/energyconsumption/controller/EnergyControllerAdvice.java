package com.pp.energyconsumption.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pp.energyconsumption.exception.ConstraintViolationException;
import com.pp.energyconsumption.exception.MissingHeaderInfoException;
import com.pp.energyconsumption.exception.NumberFormatException;
import com.pp.energyconsumption.exception.RecordNotFoundException;
import com.pp.energyconsumption.model.ErrorResponse;

/**
 * 
 * @author prathameshpawar
 *
 */
@ControllerAdvice
public class EnergyControllerAdvice extends ResponseEntityExceptionHandler {
	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
	private String BAD_REQUEST = "BAD_REQUEST";

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MissingHeaderInfoException.class)
	public final ResponseEntity<ErrorResponse> handleInvalidHeaderException(MissingHeaderInfoException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Incorrect/missing param:" + ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Please enter Number only: " + ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NumberFormatException.class)
	public final ResponseEntity<ErrorResponse> handleNumberFormatException(ConstraintViolationException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Please enter Number only:: " + ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}