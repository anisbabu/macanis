package com.armr.core.auth.model;

public class OrgUnit extends Base {
    @ManyToOne
    private OrgUnit orgUnit;
    private String code;
    
    @ManyToOne
    private MetaData orgUnitKey;
    
    @Enumerated(EnumType.STRING)
    private OrgType orgType;
}
