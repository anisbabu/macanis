package com.armr.core.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class RegisterRequestDto {

    @NotBlank
    private String username;

    @Column(length = 15)
    private String displayName;

    @NotBlank
    private String countryKey; //bd, in, us, uk, etc.

    //@Column(unique = true, nullable = false, length = 15)
    @NotBlank
    private String mobile; // based on country code

    //@Column(unique = true, length = 50)
    //@NotBlank
    private String email;

    //@Column(nullable = false, length = 64)
    @NotBlank
    private String password;

}
