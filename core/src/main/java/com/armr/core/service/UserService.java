package com.armr.core.service;


import com.armr.core.config.JwtUtil;
import com.armr.core.dto.LoginRequestDto;
import com.armr.core.model.AuthUser;
import com.armr.core.repo.AuthPermissionRepo;
import com.armr.core.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService  {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthPermissionRepo authPermissionRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;

  public   ResponseEntity<?> login(LoginRequestDto request ){
        Optional<AuthUser> userOptional = userRepo.findByUsername(request.getUsername());
        if (userOptional.isPresent()) {
            if(passwordEncoder.matches(request.getPassword(), userOptional.get().getPassword())){
                String token = jwtUtil.generateToken(request.getUsername());
                return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
            }else
                return ResponseEntity.status(401).body("Invalid password");
        } else {
            return ResponseEntity.status(401).body("Invalid username");
        }
    }

    public Optional<AuthUser> findByUsername(String username) {
     return userRepo.findByUsername(username);
    }
}
