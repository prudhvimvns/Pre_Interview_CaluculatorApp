package com.example.CalculatorApplication.CalculatorApplication.controller;

import com.example.CalculatorApplication.CalculatorApplication.model.Operation;
import com.example.CalculatorApplication.CalculatorApplication.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public double calculate(@RequestParam Operation operation, @RequestParam double num1, @RequestParam double num2) {
        return calculatorService.calculate(operation, num1, num2);
    }

    @PostMapping("/chain")
    public double chainOperations(@RequestParam double initial, @RequestParam Operation[] operations, @RequestParam double[] values) {
        if (operations.length != values.length) {
            throw new IllegalArgumentException("Number of operations must match number of values");
        }

        CalculatorService chainedService = calculatorService;
        chainedService.chain(Operation.ADD, initial);

        for (int i = 0; i < operations.length; i++) {
            chainedService.chain(operations[i], values[i]);
        }

        return chainedService.getResult();
    }
}
