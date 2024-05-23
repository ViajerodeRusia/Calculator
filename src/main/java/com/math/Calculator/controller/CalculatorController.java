package com.math.Calculator.controller;

import com.math.Calculator.exception.DivisionByZeroException;
import com.math.Calculator.exception.EmptyParametersException;
import com.math.Calculator.service.CalculatorService;
import com.math.Calculator.service.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    // Constructor to inject CalculatorService
    public CalculatorController(@Autowired CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // Handle GET requests to /calculator
    @GetMapping("/calculator")
    public String calculatorForm(Model model) {
        model.addAttribute("result", "");
        return "calculator";
    }

    // Handle POST requests to /calculate
    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") Integer num1,
                            @RequestParam("num2") Integer num2,
                            @RequestParam("operation") Operation operation,
                            Model model) {
        try {
            double result = calculatorService.calculate(num1, num2, operation);
            model.addAttribute("result", "Result: " + result);
        } catch (DivisionByZeroException e) {
            model.addAttribute("result", "You are trying to divide by zero");
            return "calculator";
        } catch (EmptyParametersException e) {
            model.addAttribute("result", "One or both parameters are null");
            return "calculator";
        }

        return "calculator";
    }
}