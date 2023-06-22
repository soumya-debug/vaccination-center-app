package com.example.vaccinationcenter.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Comparator;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            validationErrorResponse.addError(error.getField(), error.getDefaultMessage());
        });
        Collections.sort(validationErrorResponse.getErrors(), Comparator.comparing(ValidationErrorResponse.ErrorDetail::getField));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorResponse);
    }

    // Other exception handlers can be added here

}
