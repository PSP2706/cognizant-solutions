package com.cognizant.jwtauthservice.controller;

import com.cognizant.jwtauthservice.model.AuthRequest;
import com.cognizant.jwtauthservice.model.AuthResponse;
import com.cognizant.jwtauthservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest request) {
        // Simulate static login check (can be replaced with DB/LDAP/AD)
        if ("admin".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return new AuthResponse(token);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @GetMapping("/secure-data")
    public String secured() {
        return "This is secured data.";
    }
}
