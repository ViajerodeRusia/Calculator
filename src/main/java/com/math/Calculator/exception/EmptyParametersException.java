package com.math.Calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception for empty parameters with HTTP status 400
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyParametersException extends IllegalArgumentException {
    public EmptyParametersException(String message) {
        super(message);
    }
}