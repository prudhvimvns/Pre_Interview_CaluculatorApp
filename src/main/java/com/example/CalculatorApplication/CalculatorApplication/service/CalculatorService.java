package com.example.CalculatorApplication.CalculatorApplication.service;

import com.example.CalculatorApplication.CalculatorApplication.model.Operation;

public interface CalculatorService {
    double calculate(Operation operation, double num1, double num2);
    CalculatorService chain(Operation operation, double value);
    double getResult();
}
