package com.armr.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

    private String token;  // JWT or any other token
    private String username;  // User's username (or email)
    private String companyCode;  // User's username (or email)
    private String role;  // User's role (optional, based on your app)
    private String message;  // Message to show, e.g., "Login successful"
}
