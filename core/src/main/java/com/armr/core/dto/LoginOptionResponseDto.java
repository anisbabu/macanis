package com.armr.core.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class LoginOptionResponseDto {
    private String requestId;
    private String authUserId;
    private List<Map<String, String>> companySelectionMap;
    private IntermediateProcessType intermediateProcessType;
    private String message;  // Message to show, e.g., "Login successful"

    public LoginOptionResponseDto(String requestId, String authUserId,
                                  List<Map<String, String>> companySelectionMap,
                                  IntermediateProcessType intermediateProcessType,
                                  String message) {

        this.requestId = requestId;
        this.authUserId = authUserId;
        this.companySelectionMap = companySelectionMap;
        this.intermediateProcessType = intermediateProcessType;
        this.message = message;

    }
}
