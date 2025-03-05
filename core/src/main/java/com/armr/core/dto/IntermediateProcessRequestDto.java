package com.armr.core.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class IntermediateProcessRequestDto {

    private String requestId;
    private String authUserId;
    private IntermediateProcessType intermediateProcessType;
    private String selectedCompanyCode;
    private String otp;


}
