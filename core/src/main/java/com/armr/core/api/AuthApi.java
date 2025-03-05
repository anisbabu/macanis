package com.armr.core.api;


import com.armr.core.dto.IntermediateProcessRequestDto;
import com.armr.core.dto.LoginRequestDto;
import com.armr.core.dto.RegisterRequestDto;
import com.armr.core.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthApi {

    private final AuthService authService;

    public AuthApi(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/test")
    public String test() {
        return "ssssssssssssss";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDto request) {
        if (authService.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

//        User user = new User(UUID.randomUUID(), request.getUsername(), passwordEncoder.encode(request.getPassword()), "USER");
//        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {

        return authService.login(request);
    }

    @PostMapping("/intermediateProcess")
    public ResponseEntity<?> intermediateProcess(@RequestBody @Valid IntermediateProcessRequestDto request) {
        return authService.intermediateProcess(request);
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok().body("Logout successful (invalidate token manually)");
    }
}
