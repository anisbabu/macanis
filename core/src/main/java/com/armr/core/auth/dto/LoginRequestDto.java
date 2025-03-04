package com.armr.core.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {

    // @NotBlank
    //TODO company code range (3 to 6) optional
    private String companyCode;

    //user name can be email, mobile, user name of choice, not more than 50 characters and mini 4
    @NotBlank
    private String username;

    //TODO password length 6 to 20 upper, lower, number, special character
    @NotBlank
    private String password;

}