package com.lcwd.test;

import static org.junit.Assert.*;

import com.lcwd.test.services.Calculator;
import org.junit.*;

public class CalculatorFixtureTest {

    private Calculator calc;

    // Setup: runs before each test
    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup complete");
    }

    // Teardown: runs after each test
    @After
    public void tearDown() {
        calc = null;
        System.out.println("Teardown complete");
    }

    @Test
    public void testAddition_AAA() {
        // Arrange
        int a = 3;
        int b = 4;

        // Act
        int result = calc.add(a, b);

        // Assert
        assertEquals(7, result);
    }

    @Test
    public void testMultiplication_AAA() {
        // Arrange
        int a = 5;
        int b = 6;

        // Act
        int result = calc.multiply(a, b);

        // Assert
        assertEquals(30, result);
    }
}
