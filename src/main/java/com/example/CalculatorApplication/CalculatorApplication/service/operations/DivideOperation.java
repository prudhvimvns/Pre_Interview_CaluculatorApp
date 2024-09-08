package com.example.CalculatorApplication.CalculatorApplication.service.operations;

import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements CalculationOperation {
    @Override
    public double apply(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}
