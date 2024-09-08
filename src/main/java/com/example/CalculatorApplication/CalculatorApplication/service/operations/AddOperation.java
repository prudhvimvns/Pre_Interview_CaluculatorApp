package com.example.CalculatorApplication.CalculatorApplication.service.operations;

import org.springframework.stereotype.Component;

@Component
public class AddOperation implements CalculationOperation {
    @Override
    public double apply(double num1, double num2) {
        return num1 + num2;
    }
}
