package com.armr.core.dto;

import lombok.Data;

import java.util.UUID;

@Data
class CompanyDTO {
    private UUID companyGroupId;
    private String code;
    private String name;
    private String nameNative;
    private String countryKey;
    private String currencyKey;
    private String logo;
}