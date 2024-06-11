package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        return userService.authenticate(username, password);
    }

    @PostMapping("/register")
    public void register(@RequestParam String username, @RequestParam String password,
                         @RequestParam String fullName, @RequestParam String email) {
        userService.register(username, password, fullName, email);
    }

    @PostMapping("/changePassword")
    public void changePassword(@RequestParam String username, @RequestParam String newPassword) {
        userService.changePassword(username, newPassword);
    }
}
