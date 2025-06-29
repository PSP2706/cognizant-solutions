package com.lcwd.test;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class NetworkServiceTest {
    @Test
    void testServiceWithMockNetworkClient() {
        NetworkClient mockClient = mock(NetworkClient.class);
        when(mockClient.connect()).thenReturn("Mock Connection");
        NetworkService networkService = new NetworkService(mockClient);
        assertEquals("Connected to Mock Connection", networkService.connectToServer());
    }
}