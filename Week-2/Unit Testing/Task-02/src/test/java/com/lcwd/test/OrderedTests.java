package com.lcwd.test;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Second Test");
    }

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("First Test");
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("Third Test");
    }
}
