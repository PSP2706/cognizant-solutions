package com.lcwd.test;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class ApiServiceTest {
    @Test
    void testServiceWithMockRestClient() {
        RestClient mockClient = mock(RestClient.class);
        when(mockClient.getResponse()).thenReturn("Mock Response");
        ApiService apiService = new ApiService(mockClient);
        assertEquals("Fetched Mock Response", apiService.fetchData());
    }
}