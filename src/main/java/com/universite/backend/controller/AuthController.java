package com.universite.backend.controller;

import com.universite.backend.model.User;
import com.universite.backend.security.JwtUtil;
import com.universite.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ Comparaison sécurisée
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = JwtUtil.generateToken(username);

        return Map.of("token", token);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        // ✅ Hash du mot de passe avant sauvegarde
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userService.save(user);
    }
}


