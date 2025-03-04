package com.armr.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class AuthPermission {
    @Id
    @GeneratedValue
    private UUID id;

    private String clientId;

    private String companyCode;

    @ManyToOne
    private AuthUser user;

    private String roles; // ROLE WILL BE DEVINED SPECFICALLY
    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
}
