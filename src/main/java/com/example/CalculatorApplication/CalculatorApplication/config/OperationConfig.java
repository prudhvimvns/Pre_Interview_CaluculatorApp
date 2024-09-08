package com.example.CalculatorApplication.CalculatorApplication.config;

import com.example.CalculatorApplication.CalculatorApplication.model.Operation;
import com.example.CalculatorApplication.CalculatorApplication.service.operations.CalculationOperation;
import com.example.CalculatorApplication.CalculatorApplication.service.operations.AddOperation;
import com.example.CalculatorApplication.CalculatorApplication.service.operations.DivideOperation;
import com.example.CalculatorApplication.CalculatorApplication.service.operations.MultiplyOperation;
import com.example.CalculatorApplication.CalculatorApplication.service.operations.SubtractOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class OperationConfig {

    @Bean
    public Map<Operation, CalculationOperation> operationMap(
            AddOperation addition,
            SubtractOperation subtraction,
            MultiplyOperation multiplication,
            DivideOperation division) {

        Map<Operation, CalculationOperation> map = new HashMap<>();
        map.put(Operation.ADD, addition);
        map.put(Operation.SUBTRACT, subtraction);
        map.put(Operation.MULTIPLY, multiplication);
        map.put(Operation.DIVIDE, division);

        return map;
    }
}