package com.example.CalculatorApplication.CalculatorApplication;

import com.example.CalculatorApplication.CalculatorApplication.model.Operation;
import com.example.CalculatorApplication.CalculatorApplication.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testAddition() {
        assertEquals(5, calculatorService.calculate(Operation.ADD, 2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calculatorService.calculate(Operation.SUBTRACT, 5, 4));
    }

    @Test
    void testMultiplication() {
        assertEquals(10, calculatorService.calculate(Operation.MULTIPLY, 2, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculatorService.calculate(Operation.DIVIDE, 10, 5));
    }

    @Test
    void testChaining() {
        assertEquals(16, calculatorService.chain(Operation.ADD, 5)
                .chain(Operation.MULTIPLY, 2)
                .chain(Operation.SUBTRACT, 2)
                .getResult());
    }
}