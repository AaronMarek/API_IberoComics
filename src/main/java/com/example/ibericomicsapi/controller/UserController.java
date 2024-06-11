package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.service.UserService;
import com.example.ibericomicsapi.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (userService.authenticate(username, password)) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public void register(@RequestParam String username, @RequestParam String password,
                         @RequestParam String fullName, @RequestParam String email) {
        userService.register(username, password, fullName, email);
    }

    @PostMapping("/changePassword")
    public void changePassword(@RequestParam String username, @RequestParam String newPassword,
                               @RequestHeader("Authorization") String token) {
        if (jwtUtil.validateToken(token, username)) {
            userService.changePassword(username, newPassword);
        } else {
            throw new RuntimeException("Invalid token");
        }
    }
}
