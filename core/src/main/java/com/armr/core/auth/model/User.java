package com.armr.core.auth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.util.UUID;

@Entity
@Data
@Table(name = "AUTH_USER")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(length = 15)
    private String displayName;


    @Column(nullable = false, length = 5)
     private String countryKey; //bd, in, us, uk, etc.

     @Column(unique = true, nullable = false, length = 15)
     private String mobile; // based on country code

     @Column(unique = true, length = 50)
     private String email;
    
    @Column(nullable = false, length = 64)
    private String password;

    // @Column(nullable = false)
    // private String role;


}