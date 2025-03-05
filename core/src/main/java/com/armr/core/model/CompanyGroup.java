package com.armr.core.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CompanyGroup extends Base {
    private String code;
    private String name;
    private String nameNative;
    private String countryKey;
    private String logo;
}