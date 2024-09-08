# **Calculator Application**

## Overview

This project presents a robust and extensible calculator application built using Java and Spring Boot. The application handles fundamental arithmetic operations—addition, subtraction, multiplication, and division—and supports chaining multiple operations on a single value. It adheres to object-oriented principles, including the Open-Closed Principle, ensuring maintainability and extensibility.

## Features

- **Basic Operations**: Supports addition, subtraction, multiplication, and division.
- **Chaining Operations**: Facilitates chaining multiple operations to be performed sequentially on a single input value.
- **Extensible Design**: New operations can be seamlessly integrated without altering the existing codebase.
- **Inversion of Control (IoC)**: Utilizes Spring's IoC container for effective dependency management.

## Design Decisions

### Object-Oriented Principles

1. **Open-Closed Principle**:
    - The `CalculatorService` class remains unchanged when introducing new operations. Each new operation is implemented as an individual class that conforms to a shared `CalculationOperation` interface.

2. **Dependency Injection**:
    - Operations are managed through Spring’s IoC container, simplifying the swapping and testing of components.

### Extensibility

- Operations are defined as discrete classes implementing the `CalculationOperation` interface. This design allows for easy addition of new operations without modifying the core `CalculatorService` class.

### Error Handling

- The application manages unsupported operations gracefully by throwing an `UnsupportedOperationException` when an unrecognized operation is requested.

## Structure

### Packages

- `com.example.calculator`: The root package encompassing the application configuration and main class.
- `service`: Houses the `CalculatorService` interface and its implementation.
- `model`: Contains the `Operation` enum, which defines the supported operations.
- `service.operations`: Includes classes that implement various arithmetic operations.

### Key Classes

- **`Operation` Enum**: Enumerates the supported operations: `ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`.
- **`CalculatorService` Interface**: Defines methods for performing calculations and chaining operations.
- **`CalculatorServiceImpl` Class**: Implements the `CalculatorService` interface and uses a Spring-injected map of operations.
- **`OperationConfig` Class**: Configures the map of operations through Spring’s `@Configuration` annotation.

## Usage

### Starting the Application

To start the application, run the Spring Boot application using the main class `CalculatorApplication`.

### Example Operations

You can use the REST API to perform operations.

- **Calculate Operation**:
    - **Endpoint**: `POST /api/calculator/calculate`
    - **Parameters**:
        - `operation`: `ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`
        - `num1`: The first number
        - `num2`: The second number

- **Chaining Example**:
    - **Endpoint**: `POST /api/calculator/chain`
    - **Parameters**:
        - `initial`: The starting value
        - `operations`: Comma-separated list of operations (e.g., `ADD,MULTIPLY`)
        - `values`: Comma-separated list of values for each operation

  Example Request in Postman:
  ```plaintext
  POST http://localhost:8080/api/calculator/chain
  Parameters:
    - initial: 5
    - operations: ADD,MULTIPLY
    - values: 3,2
CalculatorService calculator = new CalculatorServiceImpl(operationMap);
double result = calculator.chain(Operation.ADD, 5)
.chain(Operation.MULTIPLY, 3)
.getResult();
System.out.println("Result: " + result); // Output: Result: 15


## Assumptions
The application assumes inputs are valid. Unsupported operations will trigger exceptions.
Dependency injection is utilized to manage operations, allowing the integration of new operations without modifications to the core logic.
## Testing
Unit tests should cover the following scenarios:

Basic Operations: 
Verify the correctness of results for each operation.
Chaining Operations: Ensure that operations are correctly chained and executed in sequence.
Error Handling: Confirm that unsupported operations trigger the appropriate exceptions.
## Conclusion
This calculator application is designed with a focus on flexibility and maintainability. By leveraging Spring Boot and IoC principles, the application is easily extensible and can be integrated into larger systems with minimal changes.

Developed by Prudhvi