package com.math.Calculator.CalculatorServiceTest;

import com.math.Calculator.exception.DivisionByZeroException;
import com.math.Calculator.service.CalculatorService;
import com.math.Calculator.service.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.math.Calculator.service.Operation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {
    private Integer num1 = 10;
    private Integer num2 = 2;

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void calculate() {
        Double addResult = calculatorService.calculate(num1, num2, ADD);
        Double subtractResult = calculatorService.calculate(num1, num2, SUBTRACT);
        Double multiplyResult = calculatorService.calculate(num1, num2, MULTIPLY);
        Double divideResult = calculatorService.calculate(num1, num2, DIVIDE);

        Assertions.assertEquals(12.0, addResult);
        Assertions.assertEquals(8.0, subtractResult);
        Assertions.assertEquals(20.0, multiplyResult);
        Assertions.assertEquals(5.0, divideResult);
    }
    @Test
    void calculateThrowsExceptionForDivisionByZero() {
        Assertions.assertThrows(DivisionByZeroException.class, () ->
                calculatorService.calculate(num1, 0, DIVIDE));
    }

    @ParameterizedTest
    @CsvSource({"10, 2, ADD, 12.0",
            "10, 2, SUBTRACT, 8.0",
            "10, 2, MULTIPLY, 20.0",
            "10, 2, DIVIDE, 5.0"})
    void calculateParameterizedTest(int num1, int num2, Operation operation, double expectedResult) {
        double actualResult = calculatorService.calculate(num1, num2, operation);
        assertEquals(expectedResult, actualResult);
    }
}
