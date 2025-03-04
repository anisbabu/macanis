package com.armr.core.auth.model;

public class Company extends Base {
    @ManyToOne
    private CompanyGroup companyGroup;
    private String code;
    private String name;
    private String nameNative;
    private String countryKey;
    private String currencyKey;
    private String logo;
}