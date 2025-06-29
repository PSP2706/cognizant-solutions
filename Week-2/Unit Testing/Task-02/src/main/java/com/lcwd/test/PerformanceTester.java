package com.lcwd.test;

public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(200);  // Simulates task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
