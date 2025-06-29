package com.lcwd.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        doThrow(new RuntimeException("Failure"))
                .when(mockApi).logEvent("CRASH");

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, () -> {
            service.processEvent("CRASH");
        });

        verify(mockApi).logEvent("CRASH");
    }
}

