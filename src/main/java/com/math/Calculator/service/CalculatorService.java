package com.math.Calculator.service;

import com.math.Calculator.exception.DivisionByZeroException;
import com.math.Calculator.exception.EmptyParametersException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    // Method to perform calculation based on the provided operation
    public double calculate(Integer num1, Integer num2, Operation operation) {
        // Check if either parameter is null
        if (num1 == null || num2 == null) {
            throw new EmptyParametersException("One or both parameters are null");
        }
        // Perform the calculation based on the operation
        switch (operation) {
            case ADD:
                // Addition
                return num1 + num2;
            case SUBTRACT:
                // Subtraction
                return num1 - num2;
            case MULTIPLY:
                // Multiplication
                return num1 * num2;
            case DIVIDE:
                // Division
                // Check for division by zero
                if (num2 == 0) {
                    throw new DivisionByZeroException("You are trying to divide by zero");
                }
                return (double) num1 / num2;
            default:
                // Return 0 if the operation is not recognized
                return 0;
        }
    }
}
