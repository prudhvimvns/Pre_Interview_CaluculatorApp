package com.example.CalculatorApplication.CalculatorApplication;

import com.example.CalculatorApplication.CalculatorApplication.model.Operation;
import com.example.CalculatorApplication.CalculatorApplication.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebMvcTest
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testAddition() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/calculator/calculate")
						.param("operation", Operation.ADD.name())
						.param("num1", "2")
						.param("num2", "3"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("5.0"));
	}

	@Test
	void testChaining() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/calculator/chain")
						.param("initial", "5")
						.param("operations", Operation.ADD.name(), Operation.MULTIPLY.name())
						.param("values", "3", "2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("16.0"));
	}

}
