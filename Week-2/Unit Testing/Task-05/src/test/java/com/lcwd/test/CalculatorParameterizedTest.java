package com.lcwd.test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "4,5,9",
            "-1,1,0"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}