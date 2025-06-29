package com.lcwd.test;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class MultiReturnServiceTest {
    @Test
    void testServiceWithMultipleReturnValues() {
        Repository mockRepo = mock(Repository.class);
        when(mockRepo.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");
        Service service = new Service(mockRepo);
        assertEquals("Processed First Mock Data", service.processData());
        assertEquals("Processed Second Mock Data", service.processData());
    }
}