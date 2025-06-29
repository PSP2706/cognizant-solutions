package com.lcwd.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }
}