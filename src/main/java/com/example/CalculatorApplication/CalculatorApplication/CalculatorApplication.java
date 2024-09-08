package com.example.CalculatorApplication.CalculatorApplication;

import com.example.CalculatorApplication.CalculatorApplication.model.Operation;
import com.example.CalculatorApplication.CalculatorApplication.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication{

	@Autowired
	private CalculatorService calculatorService;

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

}
