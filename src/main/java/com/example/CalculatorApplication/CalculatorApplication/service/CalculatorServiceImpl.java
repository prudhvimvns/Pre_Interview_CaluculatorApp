package com.example.CalculatorApplication.CalculatorApplication.service;

import com.example.CalculatorApplication.CalculatorApplication.model.Operation;
import com.example.CalculatorApplication.CalculatorApplication.service.operations.CalculationOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private double result = 0.0;

    private final Map<Operation, CalculationOperation> operationMap;

    @Autowired
    public CalculatorServiceImpl(Map<Operation, CalculationOperation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public double calculate(Operation operation, double num1, double num2) {
        CalculationOperation calcOp = operationMap.get(operation);
        if (calcOp == null) {
            throw new UnsupportedOperationException("Operation not supported");
        }
        return calcOp.apply(num1, num2);
    }

    @Override
    public CalculatorService chain(Operation operation, double value) {
        this.result = calculate(operation, this.result, value);
        return this;
    }

    @Override
    public double getResult() {
        return result;
    }
}