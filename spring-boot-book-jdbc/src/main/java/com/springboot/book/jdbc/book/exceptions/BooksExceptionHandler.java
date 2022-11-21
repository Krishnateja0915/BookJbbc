package com.springboot.book.jdbc.book.exceptions;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BooksExceptionHandler {
	@ExceptionHandler(value = {SQLException.class, DataAccessException.class})
	public ResponseEntity<Object> exception() {
		return new ResponseEntity<Object>("Book not available", HttpStatus.NOT_FOUND);
	}
}
