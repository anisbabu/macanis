package com.armr.core.auth.model;

public class OperatingUnit extends Base {
    @ManyToOne
    private Company company;
    private String code;
    private String name;
    private String nameNative;
    
    @Enumerated(EnumType.STRING)
    private OperatingUnitType operatingUnitType;
}
