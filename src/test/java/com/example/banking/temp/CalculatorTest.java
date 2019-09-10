package com.example.banking.temp;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void shouldReturnFour() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 2));
    }
}