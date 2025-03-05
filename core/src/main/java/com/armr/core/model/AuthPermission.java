package com.armr.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;




@Entity
@Data
public class AuthPermission {
    @Id
    @GeneratedValue
    private String id;

    private String clientId;

   // private String companyCode;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AuthUser authUser;

    private String roles; // ROLE WILL BE DEVINED SPECFICALLY
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}
