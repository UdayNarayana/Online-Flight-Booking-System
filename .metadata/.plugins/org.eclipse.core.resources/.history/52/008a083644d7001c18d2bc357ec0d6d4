package com.airline.ticket.base.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmailNotFound(EmailNotFoundException ex) {
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(),
				"NOT_FOUND",
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidEmailFormatException.class)
	public ResponseEntity<ErrorDetails> handleInvalidEmailFormat(InvalidEmailFormatException ex) {
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				"Invalid Email Format", 
				LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PasswordNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlePasswordNotFound(PasswordNotFoundException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				"NOT_FOUND", 
				LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorDetails> handleInvalidCredentials(InvalidCredentialsException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				"Invalid Credentials", 
				LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ErrorDetails> handleInvalidUser(InvalidUserException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				"Invalid User", 
				LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleIdNotFound(IdNotFoundException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				"NOT_FOUND", 
				LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldname, message);

		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}