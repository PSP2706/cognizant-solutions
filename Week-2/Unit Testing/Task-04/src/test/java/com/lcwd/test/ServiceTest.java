package com.lcwd.test;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class ServiceTest {
    @Test
    public void testServiceWithMockRepository() {
        Repository mockRepo = mock(Repository.class);
        when(mockRepo.getData()).thenReturn("Mock Data");
        Service service = new Service(mockRepo);
        assertEquals("Processed Mock Data", service.processData());
    }
}