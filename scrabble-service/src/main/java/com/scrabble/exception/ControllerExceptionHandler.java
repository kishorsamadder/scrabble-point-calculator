package com.scrabble.exception;

import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {PropertyValueException.class, DataIntegrityViolationException.class})
    public ResponseEntity<ErrorMessage> internalException(DataIntegrityViolationException ex) {
        ErrorMessage message = new ErrorMessage( HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}