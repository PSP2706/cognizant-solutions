package com.lcwd.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskWithinTime() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofMillis(500), tester::performTask);
    }
}