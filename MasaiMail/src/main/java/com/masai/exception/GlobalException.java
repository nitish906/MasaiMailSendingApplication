package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<myErrorDetail> userException(UserException userEx, WebRequest web) {

		myErrorDetail error = new myErrorDetail(LocalDateTime.now(), userEx.getMessage(), web.getDescription(false));

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<myErrorDetail> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		myErrorDetail err = new myErrorDetail(LocalDateTime.now(), "Validation Error",
				me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<myErrorDetail> exception(Exception e, WebRequest web) {

		myErrorDetail error = new myErrorDetail(LocalDateTime.now(), e.getMessage(), web.getDescription(false));

		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
	}

}
