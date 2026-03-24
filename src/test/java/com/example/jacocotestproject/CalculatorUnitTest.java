package com.example.jacocotestproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorUnitTest {

    private Calculator calculator = new Calculator();

    @Test
    void add() {
        assertEquals(2, calculator.sum(1, 1));
    }

    @Test
    void multiply() {
        assertEquals(6, calculator.multiply(3, 2));
    }
}
