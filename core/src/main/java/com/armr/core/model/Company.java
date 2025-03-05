package com.armr.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "COMPANY")
public class Company extends Base {

    @ManyToOne(optional = true)
    private CompanyGroup companyGroup;

    private String code;
    private String name;
    private String nameNative;
    private String countryKey;
    private String currencyKey;
    private String logo;
}