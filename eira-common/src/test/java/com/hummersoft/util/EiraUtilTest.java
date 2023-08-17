package com.hummersoft.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Base64;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ContextConfiguration(classes = EiraUtil.class)
@JsonAutoDetect(fieldVisibility = ANY)
public class EiraUtilTest {

    @Spy
    @InjectMocks
    EiraUtil eiraUtil;

    @Test
    public void encodeObjectTest(){
        String mockObject = "Sample"; // Create a mock object for testing

        String encoded = eiraUtil.encodeObject(mockObject);

        // Verify that the encodeObject method was called with the mock object
        verify(eiraUtil, times(1)).encodeObject(mockObject);

        // Decode the encoded string
        String decoded = eiraUtil.decodeObject(encoded);

        // Assert that the decoded object is equal to the original mock object
        assertEquals(mockObject, decoded.replaceAll("^\"|\"$", ""));
    }

    @Test
    public void testDecodeObject() {
        String encoded = Base64.getUrlEncoder().encodeToString("test".getBytes());

        String decoded = eiraUtil.decodeObject(encoded);

        // Verify that the decodeObject method was called with the encoded string
        verify(eiraUtil, times(1)).decodeObject(encoded);

        // Assert that the decoded string is equal to the original "test" string
        assertEquals("test", decoded);
    }

}
