package com.lcwd.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        User user = new User();
        user.setId(1L);
        user.setName("Bob");
        userRepository.save(user);

        List<User> users = userRepository.findByName("Bob");
        assertFalse(users.isEmpty());
        assertEquals("Bob", users.get(0).getName());
    }
}