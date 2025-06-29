package com.lcwd.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testFullFlow() {
        User user = new User();
        user.setId(1L);
        user.setName("Alice");

        ResponseEntity<User> postResponse = restTemplate.postForEntity("/users", user, User.class);
        assertEquals(200, postResponse.getStatusCodeValue());
        assertEquals("Alice", postResponse.getBody().getName());

        ResponseEntity<User> getResponse = restTemplate.getForEntity("/users/1", User.class);
        assertEquals(200, getResponse.getStatusCodeValue());
        assertEquals("Alice", getResponse.getBody().getName());
    }
}