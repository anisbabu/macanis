package com.armr.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;



@Entity
@Data
@Table(name = "AUTH_USER")
public class AuthUser {
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(length = 15)
    private String displayName;

    @Column(nullable = false, length = 5)
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Must contain only uppercase letters and digits")
    private String countryKey; //bd, in, us, uk, etc.

    @Column(unique = true, nullable = false, length = 15)
    private String mobile; // based on country code

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    @Column(unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

}