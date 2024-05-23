package com.math.Calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception for division by zero with HTTP status 400
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DivisionByZeroException extends IllegalArgumentException {
    public DivisionByZeroException(String message) {
        super(message);
    }
}