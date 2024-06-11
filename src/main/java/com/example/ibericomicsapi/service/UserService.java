package com.example.ibericomicsapi.service;

import com.example.ibericomicsapi.model.User;
import com.example.ibericomicsapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean authenticate(String username, String password) {
        User existingUser = userRepository.findByUsername(username);
        return existingUser != null && passwordEncoder.matches(password, existingUser.getPassword());
    }

    public void register(String username, String password, String fullName, String email) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        userRepository.save(newUser);
    }

    public void changePassword(String username, String newPassword) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            existingUser.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(existingUser);
        }
    }
}
