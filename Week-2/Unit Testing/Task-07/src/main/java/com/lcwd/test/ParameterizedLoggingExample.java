package com.lcwd.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Partha";
        int age = 25;
        logger.info("User name: {} and age: {}", user, age);
    }
}