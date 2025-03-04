package com.armr.core.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {

    // @NotBlank
    //TODO company code range (3 to 6) optional
    private String companyCode;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}