package com.armr.core.api;


import com.armr.core.config.JwtUtil;
import com.armr.core.dto.LoginRequestDto;
import com.armr.core.dto.RegisterRequestDto;
import com.armr.core.model.AuthUser;
import com.armr.core.repo.UserRepo;
import com.armr.core.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthApi {

    private final UserService userRepository;

    public AuthApi(UserService userRepository ) {
        this.userRepository = userRepository;

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDto request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

//        User user = new User(UUID.randomUUID(), request.getUsername(), passwordEncoder.encode(request.getPassword()), "USER");
//        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDto request) {
     return userRepository.login(request);
    }

    @PostMapping("/otpProcess")
    public ResponseEntity<?> otpProcess(@RequestBody @Valid LoginRequestDto request) {
        return userRepository.login(request);
    }

    @PostMapping("/companySelection")
    public ResponseEntity<?> companySelection(@RequestBody @Valid LoginRequestDto request) {
        return userRepository.login(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok().body("Logout successful (invalidate token manually)");
    }
}
