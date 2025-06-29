package com.lcwd.test;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class FileServiceTest {
    @Test
    void testServiceWithMockFileIO() {
        FileReader mockReader = mock(FileReader.class);
        FileWriter mockWriter = mock(FileWriter.class);
        when(mockReader.read()).thenReturn("Mock File Content");
        FileService fileService = new FileService(mockReader, mockWriter);
        assertEquals("Processed Mock File Content", fileService.processFile());
    }
}